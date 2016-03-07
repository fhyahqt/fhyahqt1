package www;

import java.util.List;

import com.jfinal.core.Controller;

import config.Map;

public class HTML_selectsql extends Controller {
	List<Map> selectresult;
	public void index(){
		selectresult = Map.dao.find("select * from var_map_info");
		//selectresult = Map.dao.find("select * from blog");
		this.render("/www/index.html");
		//renderJson(selectresult);
	}
}
