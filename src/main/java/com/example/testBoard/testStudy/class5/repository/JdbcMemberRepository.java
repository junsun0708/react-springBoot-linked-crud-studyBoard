package com.example.testBoard.testStudy.class5.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

import com.example.testBoard.testStudy.class5.domain.Member;

//귀찮 대충 하나만
public class JdbcMemberRepository implements MemberRepository {

	private final DataSource datasource;

	public JdbcMemberRepository(DataSource datasource) {
		this.datasource = datasource;
	}

	private Connection getConnection() {
		return  DataSourceUtils.getConnection(datasource);//이걸 써야 커넥션이 여러개 안생김
	}

	@Override
	public Member save(Member member) {
		String sql = "insert into member(name) values(?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, member.getName());
			pstmt.executeUpdate();

			rs = pstmt.getGeneratedKeys();

			if (rs.next()) {
				member.setId(rs.getLong(1));
			} else {
				throw new SQLException("id 조회실패");
			}
		} catch (Exception e) {
			throw new IllegalStateException();
		} finally {
			//close(conn, pstmt, rs);
		}
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		return Optional.empty();
	}

	@Override
	public Optional<Member> findByName(String name) {
		return Optional.empty();
	}

	@Override
	public List<Member> findAll() {
		return null;
	}
}
