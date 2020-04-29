package rtest;
import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Service;
@Service
public class OnePersonService {
	public String returnGu(String path, String namegu)  {
		RConnection r = null;
		String retStr = "";
		try {
			r = new RConnection();
			r.eval("library(dplyr)");
			r.eval("library(Kormaps)");
			r.eval("library(leaflet)");
			r.eval("Encoding(names(korpopmap2))<-'UTF-8'");
			r.eval("Encoding(korpopmap2@data$name)<-'UTF-8'");
			r.eval("Encoding(korpopmap2@data$행정구역별_읍면동)<-'UTF-8'");
			r.eval("Encoding(names(korpopmap3))<-'UTF-8'");
			r.eval("Encoding(korpopmap3@data$name)<-'UTF-8'");
			r.eval("Encoding(korpopmap3@data$행정구역별_읍면동)<-'UTF-8'");
			r.eval("k2 <- korpopmap2");
			r.eval("k3 <- korpopmap3");
			//r.assign("guname", namegu);
			r.eval("guname <- '"+namegu+"'");
			r.eval("gucode <- k2@data[k2@data$name == guname,'code.data']");
			r.eval("pattern <- paste0('^',gucode)");
			r.eval("k3@data<-korpopmap3@data[grep(pattern, korpopmap3@data$code.data),]");
			r.eval("k3@polygons<-korpopmap3@polygons[grep(pattern, korpopmap3@data$code.data)]");
			r.eval("k3@data$name<-gsub('·','',k3@data$name)");
			r.eval("DONG <- read.csv('data/one.csv')");
			r.eval("colnames(DONG)<-c('구별','name','일인가구')");
			r.eval("dong <- DONG %>% filter(구별=='"+namegu+"')");
			r.eval("k3@data<-merge(k3@data, dong, by.x='name', sort=FALSE)");
			r.eval("mymap <- k3@data");
			r.eval("mypalette <- colorNumeric(palette = 'Set1', domain = k3@data$'일인가구')");
			r.eval("mypopup <- paste0(mymap$name,'<br> 1인가구 : ', k3@data$'일인가구')");
			r.eval("library(ggmap)");
			r.eval("register_google(key='AIzaSyD8k2DWC_7yFHCrH6LDR3RfITsmWMEqC8c')");
			r.eval("gucheong <- '"+namegu+"청'");
			r.eval("gucheongloc <- geocode(enc2utf8(gucheong))");
			r.eval("library(rgeos)");
			r.eval("gunamemap<-NULL");
			r.eval("gunamemap <- leaflet(k3) %>% addTiles() %>% setView(lat = gucheongloc$lat, lng = gucheongloc$lon,zoom = 12) %>% addPolygons(stroke = FALSE,fillOpacity = .7,popup = mypopup, color = ~mypalette(k3@data$일인가구)) %>% addLegend(values = ~k3@data$일인가구, pal = mypalette, title = '인구수', opacity = 1)");
			//r.eval("gunamemap <- leaflet(k3) %>% addTiles() %>% setView(lat=37.52711, lng=126.987517,zoom = 12) %>% addPolygons(stroke = FALSE,fillOpacity = .7,popup = mypopup, color = ~mypalette(k3@data$일인가구)) %>% addLegend(values = ~k3@data$일인가구, pal = mypalette, title = '인구수', opacity = 1)");
			r.eval("gunamemap");
			String fileName = path + "/index.html";
			
			r.eval("saveWidget(gunamemap,'"+fileName+"',  selfcontained = F)");	    
			retStr = r.eval("'index.html'").asString();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			r.close(); 
		}
		return retStr;
		
	}
}
