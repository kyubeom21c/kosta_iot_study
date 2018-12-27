package test.com;

import java.util.List;

public interface NoteBookDAO {

	// CRUD
	public int insert(NoteBookVO vo);

	public int update(NoteBookVO vo);

	public int delete(NoteBookVO vo);

	public NoteBookVO selectOne(NoteBookVO vo);

	public List<NoteBookVO> selectAll();

}
