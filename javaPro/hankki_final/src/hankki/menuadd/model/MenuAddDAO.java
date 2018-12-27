package hankki.menuadd.model;

import java.util.List;

public interface MenuAddDAO {
	public int insert(MenuAddVO vo);
 //접근재어   반환타입 함수이름  매개변수(input받는값의 타입)
	public int update(MenuAddVO vo);

	public int delete(MenuAddVO vo);

	public MenuAddVO selectOne(MenuAddVO vo);

	public List<MenuAddVO> selectAll();
	
	public List<MenuAddVO> selectKind(String keyword);
	
	public List<MenuAddVO> like(String keyword);

}
