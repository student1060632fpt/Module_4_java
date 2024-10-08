package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javaBeans.LoaiHoa;

public class LoaiHoaBL {
	private static JdbcTemplate jdbc = CSDL.getJdbc();
	public static List<LoaiHoa> getLoaiHoas(){
		String sql = "SELECT * FROM loaihoa";
		return jdbc.query(sql, new RowMapper<LoaiHoa>() {
			@Override
			public LoaiHoa mapRow(ResultSet rs, int numRow) throws SQLException {
				LoaiHoa lh = new LoaiHoa();
				lh.setMaLoai(rs.getInt("Maloai"));
				lh.setTenLoai(rs.getString("Tenloai"));
				return lh;
			}
		});
	}
	public static void main(String[] args) {
		List<LoaiHoa> lh = getLoaiHoas();
		lh.forEach(h -> System.out.println(h.getTenLoai()));
	}
}
