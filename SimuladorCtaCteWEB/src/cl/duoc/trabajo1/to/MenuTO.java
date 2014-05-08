package cl.duoc.trabajo1.to;

public class MenuTO {
	private int id;
    private String menu;
    private String url;
    private String subMenu;
    private String subUrl;
    private int orden;
    
	public MenuTO() {
		this.id = 0;
		this.menu = new String();
		this.url = new String();
		this.subMenu = new String();
		this.subUrl = new String();
		this.orden = 0;
	}
	
	public MenuTO(int id, String menu, String url, String subMenu, String subUrl, int orden) {
		this.id = id;
		this.menu = menu;
		this.url = url;
		this.subMenu = subMenu;
		this.subUrl = subUrl;
		this.orden = orden;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSubMenu() {
		return subMenu;
	}
	public void setSubMenu(String subMenu) {
		this.subMenu = subMenu;
	}
	public String getSubUrl() {
		return subUrl;
	}
	public void setSubUrl(String subUrl) {
		this.subUrl = subUrl;
	}
	public int getOrden() {
		return orden;
	}
	public void setOrden(int orden) {
		this.orden = orden;
	}
    
    
}
