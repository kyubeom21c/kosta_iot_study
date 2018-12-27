package hankki.info.model;

import java.util.List;

public interface InfoDAO {

	public int insert(InfoVO vo);

	public int update(InfoVO vo);
	
	public int update_stat(InfoVO vo);

	public int delete(InfoVO vo);
	
	public InfoVO selectOne(String orderNum);

	public InfoVO selectOne(InfoVO vo);

	public List<InfoVO> selectAll();

}
