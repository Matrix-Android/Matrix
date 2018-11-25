package cn.matrix.newpojo;
import java.io.Serializable;
import java.util.Map;

/** 
* @author Du 
* @version 1.0
*/
public class Wire implements Serializable{
	private static final long serialVersionUID = 1L;
	private Phase wirePhase;
	private double wireLength;
	private double wireCsArea;
	private String wireName;			//线缆名
	private Material wireMaterial;

	public Wire(Map<PropertyList, Object> propertyList) {
		this.wirePhase = (Phase) propertyList.get(PropertyList.WIRE_PHASE);
		this.wireLength = (Double) propertyList.get(PropertyList.WIRE_LENGTH);
		this.wireCsArea = (Double) propertyList.get(PropertyList.WIRE_CSAREA);
		this.wireName = (String) propertyList.get(PropertyList.WIRE_NAME);
		this.wireMaterial = (Material) propertyList.get(PropertyList.WIRE_MATERIAL);
	}

	public Phase getWirePhase() {
		return wirePhase;
	}

	public void setWirePhase(Phase wirePhase) {
		this.wirePhase = wirePhase;
	}

	public double getWireLength() {
		return wireLength;
	}

	public void setWireLength(double wireLength) {
		this.wireLength = wireLength;
	}

	public double getWireCsArea() {
		return wireCsArea;
	}

	public void setWireCsArea(double wireCsArea) {
		this.wireCsArea = wireCsArea;
	}

	public void setWireCsArea(float wireCsArea) {
		this.wireCsArea = wireCsArea;
	}
	
	public String getWireName() {
		return wireName;
	}

	public void setWireName(String wireName) {
		this.wireName = wireName;
	}

	public Material getWireMaterial() {
		return wireMaterial;
	}

	public void setWireMaterial(Material wireMaterial) {
		this.wireMaterial = wireMaterial;
	}

	@Override
	public String toString() {
		return "Wire [wirePhase=" + wirePhase + ", wireLength=" + wireLength + ", wireCsArea=" + wireCsArea
				+ ", wireName=" + wireName + ", wireMaterial=" + wireMaterial + "]";
	}

	
	
}
