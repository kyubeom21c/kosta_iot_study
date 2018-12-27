package manage.model;

import java.util.List;

public interface ManageDAO {

	public int insert(ManageVO vo);

	public int update(ManageVO vo);

	public int delete(ManageVO vo);

	public List<ManageVO> selectAll();

	public ManageVO selectOne(ManageVO vo);

}
