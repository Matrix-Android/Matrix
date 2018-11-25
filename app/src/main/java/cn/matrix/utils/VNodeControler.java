package cn.matrix.utils;

import java.util.ArrayList;

import cn.matrix.interfaces.NodeOperate;
import cn.matrix.newpojo.PowerNode;

/**
 * @author Du:
 * @version ����ʱ�䣺2016��7��19�� ����11:20:05 ˵����
 */
public class VNodeControler {
	/*
	* 
	*/

	public static ArrayList<PowerNode> get_son_list(PowerNode powerNode) {
		return powerNode.getSonNodeList();
	}


	/* �ж��Ƿ����ӽڵ������� */
	public static boolean B_is_A_son_node(PowerNode A, PowerNode B) {
		for (PowerNode fd : A.getSonNodeList()) {
			if (fd.equals(B))
				return true;
		}
		return false;
	}

	/**
	 * 		将B添加进A的孩子列表
	 * @param fatherNode
	 * @param sonNode
	 * @return
	 */
	public static boolean buildAToBFatherSon(PowerNode fatherNode,PowerNode sonNode){
		fatherNode.getSonNodeList().add(sonNode);
		sonNode.setFatherNode(fatherNode);
		return false;
	}
	public static int getson_num(PowerNode vnode) {
		return vnode.getSonNodeList().size();
	}
	
	public static void DFS(PowerNode node, NodeOperate op) {
		if (node != null) {
			op.Operate(node);
			//为了导出所有点而做的奇怪的操作
			//OutputExcelAdapter.OutPNodelist.add(node);

			for (PowerNode son : node.getSonNodeList()) {
				DFS(son, op);
			}
		}
	}

}
