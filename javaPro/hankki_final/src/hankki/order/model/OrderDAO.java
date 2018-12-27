package hankki.order.model;

import java.util.List;

import hankki.member.model.MemberVO;

public interface OrderDAO {

	public int[] insertBatch(List<OrderVO> vos, String orderNum);

	public int insert(OrderVO vo);

	public List<OrderVO> selectOrderList(String orderNum);

	public List<OrderVO> selectOrderinfo(String tel);

	public String[][] listConvertArray(List<OrderVO> vos, int columnsCnt);

	public MemberVO userLogin(String tel, String email);

}
