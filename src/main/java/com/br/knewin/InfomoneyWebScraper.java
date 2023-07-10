package com.br.knewin;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.apache.commons.lang3.StringEscapeUtils;

@SuppressWarnings("deprecation")
public class InfomoneyWebScraper {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		String infomoneyURL = "https://www.infomoney.com.br/mercados/";
		Document infomoneyDoc = Jsoup.connect(infomoneyURL).get();
		Elements listaNoticias = infomoneyDoc.select(".articlespack-list");
		
//		Mostra notícias já indexadas na página
		System.out.println("Página 1:\n");
		mostraNoticias(listaNoticias);
		
//		Chama método 'Carregar mais'
		for (int i = 2; i <= 3; i++) {
			System.out.println("Página "+i+":\n");
			ReqCarregarMais();
			Thread.sleep(500);
		}

    }
	
//	Requisição retorna HMTL com novas notícias 
	public static void ReqCarregarMais() throws IOException {
        String url = "https://www.infomoney.com.br/?infinity=scrolling";
        String payload = "action=infinite_scroll&page=2&currentday=10.07.23&order=DESC&scripts[0]=jquery&scripts[1]=jquery-core&scripts[2]=jquery-migrate&scripts[3]=tiled-gallery&scripts[4]=infomoney-script&scripts[5]=infomoney-lazy-loading&scripts[6]=infomoney-googletagservices-async&scripts[7]=infomoney-prebid-async&scripts[8]=infomoney-ads-config&scripts[9]=the-neverending-homepage&scripts[10]=infomoney-header-js&scripts[11]=jetpack-photon&scripts[12]=infomoney_js_main&scripts[13]=live-news-plugin-instagram&scripts[14]=livenews_js_main&scripts[15]=livenews_js_mustache&scripts[16]=livenews_js_moment&scripts[17]=live-news-plugin-signalr&scripts[18]=live-news-plugin-jquery-signalr&scripts[19]=live-news-plugin-infra-socket-signalr&scripts[20]=live-news-plugin-infra-ajax&scripts[21]=live-news-plugin-service-materia&scripts[22]=live-news-plugin-live&scripts[23]=jetpack-carousel&scripts[24]=infomoney_sw_register_script&scripts[25]=jetpack-lazy-images-polyfill-intersectionobserver&scripts[26]=jetpack-lazy-images&scripts[27]=jetpack-stats&scripts[28]=infomoney-bootstrap-script&scripts[29]=infomoney-email-hasg&scripts[30]=infomoney-lazy-loading-menu&scripts[31]=widget_builder_mustache_cdn&scripts[32]=widget_builder_register_events&scripts[33]=widget_builder_service_ajax&scripts[34]=widget_builder_service_ticker&scripts[35]=widget_builder_ticker_datagrid_filter&scripts[36]=widget_builder_ticker_datagrid_table&scripts[37]=widget_builder_ticker_datagrid&styles[0]=infomoney-call-to-action&styles[1]=the-neverending-homepage&styles[2]=infomoney-header&styles[3]=jetpack-videopress-video-block-view&styles[4]=mediaelement&styles[5]=wp-mediaelement&styles[6]=elasticpress-facet-style&styles[7]=elasticpress-related-posts-block&styles[8]=classic-theme-styles&styles[9]=global-styles&styles[10]=livenews_css_main&styles[11]=jetpack-carousel-swiper-css&styles[12]=jetpack-carousel&styles[13]=tiled-gallery&styles[14]=infomoney-bootstrap-preload&styles[15]=infomoney-bootstrap&styles[16]=infomoney-style-preload&styles[17]=infomoney-style&styles[18]=infomoney-author-preload&styles[19]=infomoney-author&styles[20]=infomoney-category-preload&styles[21]=infomoney-category&styles[22]=infomoney-widget-imtv-preload&styles[23]=infomoney-widget-imtv&styles[24]=infomoney-fonts-material-icons-preload&styles[25]=infomoney-fonts-material-icons&styles[26]=infomoney-script-prescriptload&styles[27]=infomoney-widget-advertising-preload&styles[28]=infomoney-widget-advertising&styles[29]=infomoney-widget-ticker&styles[30]=infomoney-page-tag&styles[31]=page-taxonomy&styles[32]=foundation&styles[33]=widget-css&query_args[category_name]=mercados&query_args[error]=&query_args[m]=&query_args[p]=0&query_args[post_parent]=&query_args[subpost]=&query_args[subpost_id]=&query_args[attachment]=&query_args[attachment_id]=0&query_args[name]=&query_args[pagename]=&query_args[page_id]=0&query_args[second]=&query_args[minute]=&query_args[hour]=&query_args[day]=0&query_args[monthnum]=0&query_args[year]=0&query_args[w]=0&query_args[tag]=&query_args[cat]=1&query_args[tag_id]=&query_args[author]=&query_args[author_name]=&query_args[feed]=&query_args[tb]=&query_args[paged]=0&query_args[meta_key]=&query_args[meta_value]=&query_args[preview]=&query_args[s]=&query_args[sentence]=&query_args[title]=&query_args[fields]=&query_args[menu_order]=&query_args[embed]=&query_args[category__in][]=&query_args[category__not_in][]=&query_args[category__and][]=&query_args[post__in][]=&query_args[post__not_in][]=&query_args[post_name__in][]=&query_args[tag__in][]=&query_args[tag__not_in][]=&query_args[tag__and][]=&query_args[tag_slug__in][]=&query_args[tag_slug__and][]=&query_args[post_parent__in][]=&query_args[post_parent__not_in][]=&query_args[author__in][]=&query_args[author__not_in][]=&query_args[search_columns][]=&query_args[posts_per_page]=10&query_args[post_type][]=&query_args[ignore_sticky_posts]=false&query_args[suppress_filters]=false&query_args[cache_results]=true&query_args[update_post_term_cache]=true&query_args[update_menu_item_cache]=false&query_args[lazy_load_term_meta]=true&query_args[update_post_meta_cache]=true&query_args[nopaging]=false&query_args[comments_per_page]=50&query_args[no_found_rows]=false&query_args[order]=DESC&query_before=2023-07-10%2013%3A09%3A26&last_post_date=2023-07-10%2009%3A29%3A40";
        Connection.Response response = Jsoup.connect(url)
                .method(Connection.Method.POST)
                .header("origin", "https://www.infomoney.com.br")
                .header("referer", "https://www.infomoney.com.br/mercados/")
                .header("sec-ch-ua", "\"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114\"")
                .header("sec-ch-ua-mobile", "?0")
                .header("sec-ch-ua-platform", "\"Linux\"")
                .header("sec-fetch-dest", "empty")
                .header("sec-fetch-mode", "cors")
                .header("sec-fetch-site", "same-origin")
                .header("user-agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36")
                .header("x-requested-with", "XMLHttpRequest")
                .requestBody(payload)
                .ignoreContentType(true)
                .execute();
        
//      Limpa JSON para converter em Document
        int startIndex = response.body().indexOf("\"html\":\"") + "\"html\":\"".length();
        int endIndex = response.body().lastIndexOf("\"}");
        String html = response.body().substring(startIndex, endIndex);
        html = StringEscapeUtils.unescapeJava(html);
        Document noticiaReq = Jsoup.parse(html);

		Elements listaNoticiasReq = noticiaReq.select("article.article-card");
		mostraNoticias(listaNoticiasReq);
	}
	
	public static void mostraNoticias(Elements listaNoticias) throws IOException {
//      Percorre todas as notícia na lista
        for (Element noticia : listaNoticias.select(".article-card")) {
            
//        	Seleciona e acessa página da notícia
            String noticiaURL = noticia.select(".article-card__headline-link").attr("href");
            Document noticiaDoc = Jsoup.connect(noticiaURL).get();
            
            System.out.println("\nURL: "+ noticiaURL);
            System.out.println("\nTITULO: " + noticiaDoc.title());
            System.out.println("\nSUBTITULO: " + noticiaDoc.selectFirst("meta[name=description]").attr("content"));
            System.out.println("\nAUTOR: " + noticiaDoc.selectFirst("meta[name=author]").attr("content"));

            String data = noticiaDoc.selectFirst("meta[property=article:published_time]").attr("content");
            System.out.println("\nDATA DE PUBLICAÇÂO: " + formatarData(data) + "\n");

//          Pega todas as <p> da class single__content
            Elements paragrafos = noticiaDoc.select(".single__content").select("p");
            System.out.println("CONTEUDO: ");
            for (Element paragrafo : paragrafos) {
                System.out.println(paragrafo.text());
            }

            System.out.println("___________________________________________________________________________");
        }
	}
	
	public static String formatarData(String data) {
        LocalDateTime dateTime = LocalDateTime.parse(data, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        return dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
	}
	
}
