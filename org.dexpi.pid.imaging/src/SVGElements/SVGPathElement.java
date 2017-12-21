package SVGElements;

public class SVGPathElement {

	private String character;
	private int x, y;

	public SVGPathElement(String character, int x, int y) {
		super();
		this.character = character;
		this.x = x;
		this.y = y;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
