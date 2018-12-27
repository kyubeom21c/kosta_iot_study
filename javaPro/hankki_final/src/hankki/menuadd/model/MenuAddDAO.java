package hankki.menuadd.model;

import java.util.List;

public interface MenuAddDAO {
	public int insert(MenuAddVO vo);
 //�������   ��ȯŸ�� �Լ��̸�  �Ű�����(input�޴°��� Ÿ��)
	public int update(MenuAddVO vo);

	public int delete(MenuAddVO vo);

	public MenuAddVO selectOne(MenuAddVO vo);

	public List<MenuAddVO> selectAll();
	
	public List<MenuAddVO> selectKind(String keyword);
	
	public List<MenuAddVO> like(String keyword);

}
