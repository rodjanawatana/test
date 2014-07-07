package jp.co.fitec.lesson.yoneyama.web.bookstore.taglibs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import javax.sql.DataSource;

public class DropdownListTag extends TagSupport {

	private static final long serialVersionUID = -1417946577489567172L;

	private DataSource ds;
	private String tbl;
	private String key;
	private String value;
	private String selected;

	public void setTbl(String tbl) {
		this.tbl = tbl;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setDs(DataSource ds) {
		this.ds = ds;
	}
	
	public void setSelected(String selected) {
		this.selected = selected;
	}

	@Override
	public int doStartTag() throws JspException {
		
		try {
			JspWriter out = pageContext.getOut();
			out.println(createHtml(getData()));
		} catch (IOException e) {
			throw new JspException(e);
		}
		
		return SKIP_BODY;
	}
	
	private List<Object[]> getData() throws JspException {
		
		String sql = "SELECT " + key + ", " + value + " FROM " + tbl;
		
		ArrayList<Object[]> list = new ArrayList<>();
		
		try(Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql)) {
			
			while(rs.next()) {
				list.add(new Object[] {rs.getObject(1), rs.getObject(2)});
			}
			
		} catch (SQLException e) {
			throw new JspException(e);
		}
		
		return list;
	}
	
	private String createHtml(List<Object[]> list) {
		
		StringBuilder html = new StringBuilder();
		
		html.append("<select name=\"");
		html.append(key);
		html.append("\"><option value=\"\"></option>");
		
		for(Object[] data : list) {
			html.append("<option value=\"");
			html.append(data[0]);
			if(data[0].toString().equals(selected)) {
				html.append("\" selected=\"selected\">");
			} else {
				html.append("\">");
			}
			html.append(data[1]);
			html.append("</option>");
		}
		
		html.append("</select>");
		
		return html.toString();
	}
}
