package kostaco.model;

import java.util.List;

public interface KostacoDAO {

	public int insert(KostacoVO vo);

	public int update(KostacoVO vo);

	public int delete();

	public List<KostacoVO> selectAll();

	public KostacoVO selectOne(KostacoVO vo);

	public List<KostacoVO> selectCode3();

	public List<KostacoVO> selectCode2();

	public List<KostacoVO> selectCode1();
}
