package cn.matrix.newpojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static cn.matrix.newpojo.PropertyList.*;


public class PowerNode implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nodeName; 	//节点名称
	private double[] gps=new double[3];	//GPS坐标
	private int[] pixel = new int[3];	//像素坐标
	private NodeType nodeType; 			//节点类型
	private Wire wire;						//线缆
	private String uuid;					//id值
	private String nodeRemark;			//节点备注
	private ArrayList<User> users = new ArrayList<>();	//用户
	private PowerNode fatherNode;							//父节点
	private ArrayList<PowerNode> sonNodeList = new ArrayList<>();			//孩子节点

	private Map<PropertyList, Object> otherProperty = new HashMap<PropertyList, Object>();			//其他参数

	public PowerNode() {
		this.uuid = UUID.randomUUID().toString();
		this.sonNodeList = new ArrayList<PowerNode>();
	}

	public PowerNode(Map<PropertyList, Object> propertyList) {
		this.nodeType = (NodeType) propertyList.get(PropertyList.NODE_TYPE);
		this.nodeName = (String) propertyList.get(PropertyList.NODE_NAME);
		this.gps =  (double[]) propertyList.get(PropertyList.NODE_GPS);
		this.pixel = (int[]) propertyList.get(PropertyList.NODE_PIXEL);
		this.uuid = UUID.randomUUID().toString();
		this.sonNodeList = new ArrayList<PowerNode>();
		this.nodeRemark = (String) propertyList.get(PropertyList.NODE_REMARK);
		switch (nodeType){
			case TRANSFORMER:
				this.otherProperty.put(NODE_BRANCHCOUNT,propertyList.get(NODE_BRANCHCOUNT));
				this.otherProperty.put(NODE_TRANSFORMER_OUTVOLTAGE,propertyList.get(NODE_TRANSFORMER_OUTVOLTAGE));
				this.otherProperty.put(NODE_TRANSFORMER_CAPACITY,propertyList.get(NODE_TRANSFORMER_CAPACITY));
				this.otherProperty.put(NODE_TRANSFORMER_PHASE,propertyList.get(NODE_TRANSFORMER_PHASE));
				break;
			case T:
				this.wire = new Wire(propertyList);
				this.otherProperty.put(NODE_BRANCHCOUNT,propertyList.get(NODE_BRANCHCOUNT));
				this.otherProperty.put(NODE_T_JOINTRESISTANCE,propertyList.get(NODE_T_JOINTRESISTANCE));
				break;
			case VIRTUAL:
				this.wire = new Wire(propertyList);
				break;
			case USER:
				this.wire = new Wire(propertyList);
				users = (ArrayList<User>) propertyList.get(USERNODE_LIST);
				break;
		}

	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public double[] getGps() {
		return gps;
	}

	public void setGps(double[] gps) {
		this.gps = gps;
	}

	public NodeType getNodeType() {
		return nodeType;
	}

	public void setNodeType(NodeType nodeType) {
		this.nodeType = nodeType;
	}

	public Wire getWire() {
		return wire;
	}

	public void setWire(Wire wire) {
		this.wire = wire;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public PowerNode getFatherNode() {
		return fatherNode;
	}

	public void setFatherNode(PowerNode fatherNode) {
		this.fatherNode = fatherNode;
	}

	public ArrayList<PowerNode> getSonNodeList() {
		return sonNodeList;
	}

	public void setSonNodeList(ArrayList<PowerNode> sonNodeList) {
		this.sonNodeList = sonNodeList;
	}

	public String getNodeRemark() {
		return nodeRemark;
	}

	public void setNodeRemark(String nodeRemark) {
		this.nodeRemark = nodeRemark;
	}
	public Map<PropertyList, Object> getOtherProperty() {
		return otherProperty;
	}

	public void setOtherProperty(Map<PropertyList, Object> otherProperty) {
		this.otherProperty = otherProperty;
	}

	public int[] getPixel() {
		return pixel;
	}

	public void setPixel(int[] pixel) {
		this.pixel = pixel;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public int getUnfinishedBranchCount(){
		try {
			if (nodeType.equals(NodeType.T) || nodeType.equals(NodeType.TRANSFORMER)) {
				return (int) this.otherProperty.get(PropertyList.NODE_BRANCHCOUNT) - this.sonNodeList.size();
			} else {
				return 0;
			}
		}catch (Exception e){
			return 0;
		}
	}


}
