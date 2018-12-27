package hankki.menucho.model;

import java.util.List;

public interface MenuChoiceDAO {

	public List<MenuChoiceVO> selectLike(String keword);
	
	public List<MenuChoiceVO> selectKind(String keword);
	
	public List<MenuChoiceVO> selectAll(); 
	
	public String[][] listConvertArray(List<MenuChoiceVO> vos,int columnsCnt);



}
