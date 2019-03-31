package practice.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

public class ShopClient {

	static List<Shop> shops = Arrays.asList(new Shop("BestPrice"), new Shop("BestPrice01"), new Shop("BestPrice02"),
			new Shop("BestPrice03"));

	private static final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100),
			new ThreadFactory() {

				@Override
				public Thread newThread(Runnable r) {

					Thread t = new Thread(r);
					t.setDaemon(true); // 设置为守护进程 ，这种方式不会阻止程序的关停
					return t;
				}

			});

	public static void main(String[] args) {

		long start = System.nanoTime();
//		System.out.println( findPrices01("myPhones27S"));
//		System.out.println(findPrices02("myPhones27S"));
		System.out.println( findPrices03("myPhones27S"));
//		System.out.println( findPrices04("myPhones27S"));
		long duration = (System.nanoTime() - start) / 1_000_000; // 数字还有这种写法
		System.out.println("Done in " + duration + " msecs");

	}

	// 顺序流
	public static List<String> findPrices01(String product) {

		return shops.stream().map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
				.collect(Collectors.toList());
	}

	// 并行流
	public static List<String> findPrices02(String product) {

		return shops.parallelStream()
				.map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
				.collect(Collectors.toList());
	}

	// 顺序流+异步
	public static List<String> findPrices03(String product) {

		List<CompletableFuture<String>> priceFuture = shops.stream()
				.map(shop -> CompletableFuture
						.supplyAsync(() -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product))))
				.collect(Collectors.toList());

		return priceFuture.stream().map(CompletableFuture::join).collect(Collectors.toList());
	}

	// 利用线程池执行异常请求
	public static List<String> findPrices04(String product) {

		List<CompletableFuture<String>> priceFuture = shops.stream()
				.map(shop -> CompletableFuture.supplyAsync(
						() -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product), executor)))
				.collect(Collectors.toList());

		return priceFuture.stream().map(CompletableFuture::join).collect(Collectors.toList());
	}

	public static class Shop {

		final String name;

		Random random = new Random();

		public Shop(String name) {
			super();
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public static void delay() {

			try {
				Thread.sleep(1000l);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		public double getPrice(String product) {

			return calculatePrice(product);

		}

		private double calculatePrice(String product) {

			delay();

			return random.nextDouble() * product.charAt(0) + product.charAt(1);
		}

		// 异步获取价格
		public Future<Double> getPriceAsync(String product) {

			CompletableFuture<Double> futurePrice = new CompletableFuture<>();

			new Thread(() -> {
				try {
					double price = calculatePrice(product);
					futurePrice.complete(price);
				} catch (Exception ex) {
					futurePrice.completeExceptionally(ex); // 注意异常处理
				}

			}).start();

			return futurePrice;
		}

		// 异步获取价格的另一种写法
		public Future<Double> getPriceAsync01(String product) {

			return CompletableFuture.supplyAsync(() -> calculatePrice(product)); // 这里边包含了异常的处理
		}

		// 利用线程池处理异常
		public Future<Double> getPriceAsync02(String product) {

			return CompletableFuture.supplyAsync(() -> calculatePrice(product), executor); // 这里边包含了异常的处理
		}

	}/* end class shop */
}
