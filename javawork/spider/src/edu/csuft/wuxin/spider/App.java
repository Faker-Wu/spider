package edu.csuft.wuxin.spider;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App {
        
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		String url =  "https://movie.douban.com/top250";
     
		try {
			Document doc = Jsoup.connect(url).get();
			
			Elements es=doc.select(".grid_view .item");
			System.out.println(es.size());
			//创建一个存储影片的列表
			ArrayList<film> list=new ArrayList<>();
					
			for(Element e :es) {
				film f=new film();
				//每一部影片
				Element t = e.select(".title").first();
				String num=e.select(".star span").last().text();
				System.out.println(t.text()+","+num);
				
//				f.id;
//				f.title
				list.add(f);
			}
			
//			String title=doc.title();
//			String data=doc.data();
//			
//			System.out.println(title);
//			System.out.println(data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
