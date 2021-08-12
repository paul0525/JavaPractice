package practice.collection;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TestList {

    public static void main(String[] args) {

        List<UserInfo> listA = new ArrayList<UserInfo>(){{
            add(new UserInfo("paul",18));
            add(new UserInfo("paul00",19));
            add(new UserInfo("paul01",20));
        }};

        List<UserInfo> listB = new ArrayList<UserInfo>(){{
            add(new UserInfo("paul",18));
            add(new UserInfo("paul00",19));
        }};

        listA.removeIf(a->listB.contains(a));

        System.out.println( listA);
    }


    @Data
    public static class UserInfo{

        public UserInfo(String userName, int age) {
            this.userName = userName;
            this.age = age;
        }
        String userName;
        int age;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UserInfo userInfo = (UserInfo) o;
            return age == userInfo.age &&
                    Objects.equals(userName, userInfo.userName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(userName, age);
        }
    }
}
