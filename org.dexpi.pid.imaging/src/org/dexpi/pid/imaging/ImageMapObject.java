package org.dexpi.pid.imaging;

import java.util.List;

/**
 * Class for holding HTML Image-Map Elements. 
 * Example for a HTML Image Map:
 * 
 * &lt;map name="PID_image"&gt;
 * &lt;area  shape="rect" coords="61,226,113,279" alt="" title="" style="outline:none;" target="_self" href="javascript:imageclick('P4712')"     /&gt;
 * &lt;area  shape="rect" coords="122,214,157,267" alt="" title="" style="outline:none;" target="_self" href="javascript:imageclick('H1008')"     /&gt;
 * &lt;area  shape="rect" coords="176,115,256,229" alt="" title="" style="outline:none;" target="_self" href="javascript:imageclick('T4750')"     /&gt;
 * &lt;area  shape="rect" coords="264,219,307,266" alt="" title="" style="outline:none;" target="_self" href="javascript:imageclick('P4711')"     /&gt;
 * &lt;area  shape="rect" coords="352,205,429,235" alt="" title="" style="outline:none;" target="_self" href="javascript:imageclick('H1007')""     /&gt;
 * &lt;/map&gt;
 * 
 * @author michael
 *
 */
public class ImageMapObject {

	//Coordinates for the coords="x1,y1,x2,y2" attribute
	/** The x1 to y2. */
	public int x1,y1,x2,y2;
	
	/** The id. */
	public String id = "";
	
	/** The title. */
	public String title = "";
	
	/** The shape. */
	public String shape="rect";
	
	/** The href prefix. */
	public String hrefPrefix = "javascript:imageclick('";
	
	/** The href postfix. */
	public String hrefPostfix = "')";
	
	/** The style. */
	public String style = "outline:none;";
	
	/** The alt. */
	public String alt = "";
	
	/** The target. */
	public String target = "_self";
	
	
	/**
	 * Instantiates a new image map object.
	 *
	 * @param x1 int, the x1
	 * @param y1 int, the y1
	 * @param x2 int, the x2
	 * @param y2 int, the y2
	 * @param id String, the id
	 */
	public ImageMapObject(int x1, int y1, int x2, int y2, String id) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.id = id;
	}

	/**
	 * Instantiates a new image map object.
	 *
	 * @param x1 the x1
	 * @param y1 the y1
	 * @param x2 the x2
	 * @param y2 the y2
	 * @param id the id
	 * @param title the title
	 */
	public ImageMapObject(int x1, int y1, int x2, int y2, String id,
			String title) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.id = id;
		this.title = title;
	}

	/**
	 * Generates a line of code for the HTML image map, should look like this:
	 * &lt;area  shape="rect" coords="61,226,113,279" alt="" title="" style="outline:none;" target="_self" href="javascript:imageclick('P4712')"     /&gt;.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		String html = "<area ";
		html += "id=\"" +"area_"+ this.id + "\" ";
		html += "shape=\"" + this.shape + "\" ";
		html += "coords=\""+this.x1+","+this.y1+","+this.x2+","+this.y2+"\" ";
		html += "alt=\"" + this.alt + "\" ";
		html += "title=\"" + this.title + "\" ";
		html += "style=\"" + this.style + "\" ";
		html += "target=\"" + this.target + "\" ";
		html += "href=\"" + this.hrefPrefix + this.id + this.hrefPostfix + "\" ";
		html += "/>";
		return html;
	}

	/**
	 * Generate image map.
	 *
	 * @param imObjs the im objs
	 * @param mapName the map name
	 * @return the string
	 */
	public static String generateImageMap(List<ImageMapObject> imObjs, String mapName) {
		String html="<map name=\""+ mapName + "\">\n";
		for(ImageMapObject obj : imObjs) {
			html += obj.toString() + "\n";
		}
		html += "</map>";
		return html;
	}
}
