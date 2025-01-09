package Customer_Pkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB_Pkg.DBConnection;

public class CustRegisterDAO {
	int k = 0;

	public int register(CustBean cb) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into bankProject values(?,?,?,?,?,?,?,?)");
			ps.setLong(1, cb.getAccNo());
			ps.setString(2, cb.getCname());
			ps.setString(3, cb.getPword());
			ps.setLong(4, cb.getPhno());
			ps.setString(5, cb.getMail());
			ps.setLong(6, cb.getAadhar());
			ps.setDouble(7, cb.getBalance());
			ps.setString(8, cb.getAccType());
			k = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

	public CustBean loginValidate(long accNo, String pword) throws SQLException {
		CustBean cb = null;
		Connection con = DBConnection.getCon();
		PreparedStatement ps = con.prepareStatement("Select * from bankProject where AccountNo=? and Password=?");
		ps.setLong(1, accNo);
		ps.setString(2, pword);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			cb = new CustBean();
			cb.setAccNo(rs.getLong(1));
			cb.setCname(rs.getString(2));
			cb.setPword(rs.getString(3));
			cb.setPhno(rs.getLong(4));
			cb.setMail(rs.getString(5));
			cb.setAadhar(rs.getLong(6));
			cb.setBalance(rs.getDouble(7));
			cb.setAccType(rs.getString(8));
		}
		System.out.println(cb);
		return cb;

	}
	
	public double checkBalance(long accNo) {
		double balance=0.0;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("Select Balance from bankProject where AccountNo=?");
			ps.setLong(1, accNo);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				balance = rs.getDouble(1);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return balance;
		
	}
	
	
	
	public int depositAmt(double amt,long accNo) {
		
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("update bankProject set Balance=Balance+? where AccountNo=?");
			ps.setDouble(1, amt);
			ps.setLong(2,accNo);
			k=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k;
		
	}
	
	public int withdrawAmt(double amt,long accNo) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("update bankProject set Balance=Balance-? where AccountNo=?");
			ps.setDouble(1, amt);
			ps.setLong(2, accNo);
			k = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return k;
		
	}
	
	
	public int transactAmt(double amt,long sAccNo,CustBean cb){
		int k1=0,k2=0;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("update bankProject set Balance=Balance+? where AccountNo=?");
		    con.setAutoCommit(false);
		    con.setSavepoint();
			ps.setDouble(1,-amt);
		     ps.setLong(2,cb.getAccNo() );
		     k1 = ps.executeUpdate();
		     ps.setDouble(1, amt);
		     ps.setLong(2, sAccNo);
		     k2=ps.executeUpdate();
		     if(k1>0 && k2>0) {
		    	 con.commit();
		    	 k+=1;
		     }else {
		    	 con.rollback();
		     }
		     
		     
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return k;
		
		
	}
	
	public int changePassword(String oPass,String nPass,long accNo){
		
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("update bankProject set Password=? where Password=? and AccountNo=?");
		    ps.setString(1, nPass);
		    ps.setString(2, oPass);
		    ps.setLong(3, accNo);
		    k=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
