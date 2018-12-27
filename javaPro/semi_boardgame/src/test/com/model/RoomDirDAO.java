package test.com.model;

import java.util.List;

public interface RoomDirDAO {
	public int insert(RoomVO vo);

	public int delete(RoomVO vo);

	public List<RoomVO> selectAll();

	public RoomVO selectOne(RoomVO vo);
}
