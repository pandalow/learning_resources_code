package Wrapper.src.com.exerciseColleciton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class HomeWork01 {

    public static void main(String[] args) {
        ArrayList<News> news = new ArrayList<>();
        news.add(new News("新冠确诊病例超千万,数百万印度教信徒赴恒河“圣浴”引民众担忧"));
        news.add(new News("男子突然想起2个月前钓的鱼还在网兜里,捞起一看赶紧放生"));

        int size = news.size();
        for (int i = size-1;i>=0;i--){
            System.out.println(1);
        }

        ListIterator<News> newsListIterator = news.listIterator();
        while (newsListIterator.hasPrevious()) {
            News previous =  newsListIterator.previous();
            System.out.println(previous.toString().substring(0,15) +"....");
        }


        Collections.reverse(news);
        for(News a: news){
            System.out.println(a.toString().substring(0,30) +"....");
        }

    }

    static class News{
        private String title;
        private String content;
        public News(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "News{" +
                    "title='" + title + '\'' +
                    '}';
        }
    }
}
