package com.lc.task;

import com.lc.pojo.Item;
import com.lc.service.ItemsService;
import com.lc.utils.HttpUtils;
import lombok.extern.apachecommons.CommonsLog;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class ItemTask {

    @Autowired
    private HttpUtils httpUtils;
    @Autowired
    private ItemsService itemsService;

    @Scheduled(fixedDelay = 100 * 1000)
    //https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&enc=
    // utf-8&pvid=5173b59d881046e39b68cd2d4fff7877

    //https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&s=51&click=0&page=3
    public void itemTask() throws Exception {
        String url = "https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&s=51&click=0&page=";
        for (int i = 1; i < 51; i = i + 2) {
            String html = httpUtils.doGetHtml(url + i);
            //解析页面
            this.parse(html);
        }

        System.out.println("抓取完成..");
    }

    private void parse(String html) {
        Document doc = Jsoup.parse(html);
        Elements spuElenms = doc.select("div#J_goodsList > ul > li");
        for (Element spuO : spuElenms
        ) {
            Element priceElemt = spuO.select("div.p-price").first();
            Double price= Double.parseDouble(priceElemt.select("i").text());
            long spu = Long.parseLong(spuO.attr("data-spu"));
            Elements skuElems = spuElenms.select("li.ps-item");
            for (Element skuO : skuElems
            ) {
                long sku = Long.parseLong(skuO.select("[data-sku]").attr("data-sku"));
                String imgUrl = skuO.select("img[data-sku]").first().attr("src");

                Item item = new Item();
                item.setSku(sku);
                List<Item> list = itemsService.findAll(item);
                if(list.size()>0){
                    continue;
                }

                item.setSku(spu);
                String urlDetail = "https://item.jd.com/" + sku +".html";
                item.setUrl(urlDetail);
                item.setPic(imgUrl);
                item.setPrice(price);
//                item.setTitle();
                item.setCreatedtime(new Date());
                item.setUpdatetime(item.getCreatedtime());
            }






        }
    }
}
