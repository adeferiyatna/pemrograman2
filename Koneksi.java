import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Koneksi{
	Statement stmt = null;
	ResultSet rs;
	String sql_query;
	Connection conn = null;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/bookstore";
	static final String USER = "root";
	static final String PASS = "";

//terkoneksi	
	public void terhubung () {
	try {
					System.out.println("Connecting to database...");
					System.out.println("Berhasil masuk ke dalam sistem 'TOKO BUKU GARAGARAMEDIA'");
					conn = DriverManager.getConnection(DB_URL,USER,PASS);
				} 
				catch ( SQLException e ) {
					System.err.println( "Kesalahan : " + e.getMessage() );
				}
	}

//============= TABEL DATA_BUKU =============================================
//CRUD SELECT [menampilkan tabel data_buku] 
	public void tabelbuku () {
	try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM data_buku";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
			int id_buku  = rs.getInt("id_buku");
			String judul  = rs.getString("judul");
			int stok = rs.getInt("stok");
			String pengarang = rs.getString("pengarang");
			int harga = rs.getInt("harga");
			System.out.println("ID	  : " + id_buku);
			System.out.println("Judul	  : " + judul);
			System.out.println("Pengarang : " + pengarang);
			System.out.println("Harga     : " + harga);
			System.out.println("Stok  	  : " + stok +"\n");
			}
			}catch(SQLException se){
			se.printStackTrace();
			}
	}

//CRUD INSERT [tabel data_buku]
	public void insertbuku (String judul, String pengarang,int harga, int stok) {
			try{
				stmt = conn.createStatement();
				String sql = "INSERT INTO data_buku (judul,pengarang,harga,stok) VALUES('"+judul+"','"+pengarang+"','"+harga+"','"+stok+"')";
				stmt.executeUpdate(sql);
			}catch(Exception e){
				System.err.println( "Error ");
			}
	}
//CRUD UPDATE [tabel data_buku]
public void pilihbuku (int data1) {
	try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM data_buku WHERE id_buku = '"+data1+"' ";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("======================================================");
			System.out.println("=         RECORD YANG INGIN DIUPDATE                 =");
			System.out.println("=     (*Hanya stok yang dapat diupdate           =");
			System.out.println("======================================================");
			while(rs.next()){
			int id_buku  = rs.getInt("id_buku");
			String judul  = rs.getString("judul");
			int stok = rs.getInt("stok");
			int harga = rs.getInt("harga");
			String pengarang = rs.getString("pengarang");
			System.out.println("= ID	  : " + id_buku);
			System.out.println("= Judul	  : " + judul);
			System.out.println("= Pengarang : " + pengarang);
			System.out.println("= Harga : " + harga);
			System.out.println("= Stok	  : " + stok +"\n");
			System.out.println("======================================================");

			}
			}catch(SQLException se){
			se.printStackTrace();
			}
	}

public void updatebuku(int data1, String data2) {
		try {
			stmt = conn.createStatement();
			String sql = "UPDATE data_buku SET stok='"+data2+"'WHERE id_buku='"+data1+"'";
			stmt.executeUpdate(sql);
			System.out.println("Record telah diubah");
		}catch(Exception e){
			System.err.println( "Error ");
		}
	}

//CRUD DELETE [tabel data_buku]
public void deletebuku(int data1) {
		try {
			stmt = conn.createStatement();
			String sql = "DELETE FROM data_buku WHERE id_buku='"+data1+"'";
			stmt.executeUpdate(sql);
			System.out.println("Record telah dihapus");
		}catch(Exception e){
			System.err.println( "Error ");
		}
	}


//================================ BATAS TABEL DATA_BUKU ========================================


//============= TABEL DISTRIBUTOR =============================================
//CRUD SELECT [tampilan tabel distributor]
	public void tabeldistributor () {
	try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM distributor";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
			int id_distributor  = rs.getInt("id_distributor");
			String nama  = rs.getString("nama");
			String alamat = rs.getString("alamat");
			String no_telp = rs.getString("no_telp");
			System.out.println("ID Distributor 	: " + id_distributor);
			System.out.println("Nama		: " + nama);
			System.out.println("Alamat  	: " + alamat);
			System.out.println("No.Telp		: " + no_telp+"\n");
			}
			}catch(SQLException se){
			se.printStackTrace();
			}
	}

//CRUD INSERT tabel.distributor
	public void insertdistributor (String nama, String alamat, String no_telp) {
			try{
				stmt = conn.createStatement();
				String sql = "INSERT INTO distributor (nama,alamat,no_telp) VALUES('"+nama+"','"+alamat+"','"+no_telp+"')";
				stmt.executeUpdate(sql);
			}catch(Exception e){
				System.err.println( "Error ");
			}
	}


//CRUD UPDATE [tabel distributor]
public void pilihdistributor (int data1) {
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM distributor WHERE id_distributor = '"+data1+"' ";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("======================================================");
			System.out.println("=         RECORD YANG INGIN DIUPDATE                 =");
			System.out.println("=     (*Hanya alamat yang dapat diupdate             =");
			System.out.println("======================================================");
			while(rs.next()){
			int id_distributor  = rs.getInt("id_distributor");
			String nama  = rs.getString("nama");
			String alamat = rs.getString("alamat");
			String no_telp = rs.getString("no_telp");
			System.out.println("ID Distributor 	: " + id_distributor);
			System.out.println("Nama		: " + nama);
			System.out.println("Alamat  	: " + alamat);
			System.out.println("No.Telp		: " + no_telp+"\n");
			System.out.println("======================================================");
			}
			}catch(SQLException se){
			se.printStackTrace();
		}
	}

public void updatedistributor(int data1, String data2) {
		try {
			stmt = conn.createStatement();
			String sql = "UPDATE distributor SET alamat ='"+data2+"'WHERE id_distributor='"+data1+"'";
			stmt.executeUpdate(sql);
			System.out.println("Record telah diubah");
		}catch(Exception e){
			System.err.println( "Error ");
		}
	}
	
//CRUD DELETE [tabel distributor]
public void deletedistributor(int data1) {
		try {
			stmt = conn.createStatement();
			String sql = "DELETE FROM distributor WHERE id_distributor='"+data1+"'";
			stmt.executeUpdate(sql);
			System.out.println("Record telah dihapus");
		}catch(Exception e){
			System.err.println( "Error ");
		}
	}


//================================ BATAS tabel distributor ========================================


//====================== TABEL PELANGGAN ===========================
//CRUD SELECT [tampilan tabel pelanggan]
	public void tabelpelanggan () {
	try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM pelanggan";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("| ID Pelanggan |     Nama    |   Alamat   ");
			while(rs.next()){
			int id_pelanggan  = rs.getInt("id_pelanggan");
			String nama  = rs.getString("nama");
			String alamat = rs.getString("alamat");
			System.out.println("|"+id_pelanggan+"          |"+nama+"   |"+alamat);
			}
			}catch(SQLException se){
			se.printStackTrace();
			}
	}

//CRUD INSERT [tabel.pelanggan]
	public void insertpelanggan (String nama, String alamat) {
			try{
				stmt = conn.createStatement();
				String sql = "INSERT INTO pelanggan (nama,alamat) VALUES('"+nama+"','"+alamat+"')";
				stmt.executeUpdate(sql);
			}catch(Exception e){
				System.err.println( "Error ");
			}
	}
	
//CRUD UPDATE [tabel pelanggan]
public void pilihpelanggan (int data1) {
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM pelanggan WHERE id_pelanggan = '"+data1+"' ";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("======================================================");
			System.out.println("=         RECORD YANG INGIN DIUPDATE                 =");
			System.out.println("=     (*Hanya alamat yang dapat diupdate             =");
			System.out.println("======================================================");
			System.out.println("| ID Pelanggan |     Nama    |   Alamat   ");
			while(rs.next()){
			int id_pelanggan  = rs.getInt("id_pelanggan");
			String nama  = rs.getString("nama");
			String alamat = rs.getString("alamat");
			System.out.println("|"+id_pelanggan+"          |"+nama+"   |"+alamat);
			System.out.println("======================================================");
			}
			}catch(SQLException se){
			se.printStackTrace();
		}
	}

public void updatepelanggan(int data1, String data2) {
		try {
			stmt = conn.createStatement();
			String sql = "UPDATE pelanggan SET alamat ='"+data2+"'WHERE id_pelanggan='"+data1+"'";
			stmt.executeUpdate(sql);
			System.out.println("Record telah diubah");
		}catch(Exception e){
			System.err.println( "Error ");
		}
	}
	
//CRUD DELETE [tabel pelanggan]
public void deletepelanggan(int data1) {
		try {
			stmt = conn.createStatement();
			String sql = "DELETE FROM pelanggan WHERE id_pelanggan='"+data1+"'";
			stmt.executeUpdate(sql);
			System.out.println("Record telah dihapus");
		}catch(Exception e){
			System.err.println( "Error ");
		}
	}
	
//================================ BATAS tabel pelanggan ========================================

//====================== TABEL PEMBELIAN ===========================
//CRUD SELECT [tampilan tabel pembelian]
	public void tabelpembelian () {
	try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM pembelian";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("|No. Faktur | ID Distributor | ID BUKU | Jumlah Buku | Tanggal   |");
			while(rs.next()){
			int no_faktur  = rs.getInt("no_faktur");
			int id_distributor  = rs.getInt("id_distributor");
			int id_buku  = rs.getInt("id_buku");
			int jumlah_buku  = rs.getInt("jumlah_buku");
			String tanggal  = rs.getString("tanggal");
			
			System.out.println("|"+no_faktur+"   |"+id_distributor+"            |"+id_buku+"       |"+jumlah_buku+"           |"+tanggal+"|");
			}
			}catch(SQLException se){
			se.printStackTrace();
			}
	}
//CRUD INSERT [tabel.pembelian]
	public void insertpembelian (int id_distributor,int id_buku,int jumlah_buku, String tanggal) {
			try{
				stmt = conn.createStatement();
				String sql = "INSERT INTO pembelian (id_distributor,id_buku,jumlah_buku,tanggal) VALUES('"+id_distributor+"','"+id_buku+"','"+jumlah_buku+"','"+tanggal+"')";
				stmt.executeUpdate(sql);
			}catch(Exception e){
				System.err.println( "Error ");
			}
	}
	
//CRUD UPDATE [tabel pembelian]
public void pilihpembelian (int data1) {
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM pembelian WHERE no_faktur = '"+data1+"' ";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("===================================================================");
			System.out.println("=                     RECORD YANG INGIN DIUPDATE                  =");
			System.out.println("=         (*Hanya Jumlah Buku yang dapat diupdate                 =");
			System.out.println("===================================================================");
			System.out.println("|No. Faktur | ID Distributor | ID BUKU | Jumlah Buku | Tanggal   |");
			while(rs.next()){
			int no_faktur  = rs.getInt("no_faktur");
			int id_distributor  = rs.getInt("id_distributor");
			int id_buku  = rs.getInt("id_buku");
			int jumlah_buku  = rs.getInt("jumlah_buku");
			String tanggal  = rs.getString("tanggal");
			System.out.println("|"+no_faktur+"   |"+id_distributor+"            |"+id_buku+"       |"+jumlah_buku+"           |"+tanggal+"|");
			System.out.println("===================================================================");
			}
			}catch(SQLException se){
			se.printStackTrace();
		}
	}

public void updatepembelian(int data1,int data2) {
		try {
			stmt = conn.createStatement();
			String sql = "UPDATE pembelian SET jumlah_buku ='"+data2+"' WHERE no_faktur ='"+data1+"'";
			stmt.executeUpdate(sql);
			System.out.println("Record telah diubah");
		}catch(Exception e){
			System.err.println( "Error ");
		}
	}
	
//CRUD DELETE [tabel pembelian]
public void deletepembelian(int data1) {
		try {
			stmt = conn.createStatement();
			String sql = "DELETE FROM pembelian WHERE no_faktur='"+data1+"'";
			stmt.executeUpdate(sql);
			System.out.println("Record telah dihapus");
		}catch(Exception e){
			System.err.println( "Error ");
		}
	}

//================================ BATAS tabel pembelian ========================================

//====================== TABEL PENJUALAN ===========================	
//tampilan tabel penjualan
	public void tabelpenjualan () {
	try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM penjualan";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("|No. Nota | ID Pelanggan | ID BUKU | Jumlah Jual | Tanggal | Bayar");
			while(rs.next()){
			int no_nota  = rs.getInt("no_nota");
			int id_pelanggan  = rs.getInt("id_pelanggan");
			int id_buku  = rs.getInt("id_buku");
			int jumlah_jual = rs.getInt("jumlah_jual");
			String tanggal_jual  = rs.getString("tanggal_jual");
			int bayar = rs.getInt("bayar");
			System.out.println("|"+no_nota+" |"+id_pelanggan+"          |"+id_buku+"       |"+jumlah_jual+"     |"+tanggal_jual+"     |"+bayar+"");
			} 
			}catch(SQLException se){
			se.printStackTrace();
			}
	}

//CRUD INSERT [tabel.penjualan]
	public void insertpenjualan (int id_pelanggan, int id_buku, int jumlah_jual, String tanggal_jual) {
			try{
				int bayar,harga;
				String sql = "SELECT harga FROM data_buku WHERE id_buku = '"+id_buku+"' ";
				harga = rs.getInt("harga");
				bayar = jumlah_jual * harga ;
				stmt = conn.createStatement();
				sql = "INSERT INTO penjualan (id_pelanggan,id_buku,jumlah_jual,tanggal_jual,bayar) VALUES ('"+id_pelanggan+"','"+id_buku+"','"+jumlah_jual+"','"+tanggal_jual+"','"+bayar+"')";
				System.out.println(+bayar);
				stmt.executeUpdate(sql);
			}catch(Exception e){
				System.err.println( "Error ");
			}
	}
	
//CRUD UPDATE [tabel penjualan]
public void pilihpenjualan (int data1) {
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM penjualan WHERE no_nota = '"+data1+"' ";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("===================================================================");
			System.out.println("=                     RECORD YANG INGIN DIUPDATE                  =");
			System.out.println("=         (*Hanya Jumlah Buku yang dapat diupdate                 =");
			System.out.println("===================================================================");
			System.out.println("|No. Nota | ID Pelanggan | ID BUKU | Jumlah Jual | Tanggal   |");
			while(rs.next()){
			int no_nota  = rs.getInt("no_nota");
			int id_pelanggan  = rs.getInt("id_pelanggan");
			int id_buku  = rs.getInt("id_buku");
			int jumlah_jual = rs.getInt("jumlah_jual");
			String tanggal_jual  = rs.getString("tanggal_jual");
			System.out.println("|"+no_nota+" |"+id_pelanggan+"          |"+id_buku+"       |"+jumlah_jual+"     |"+tanggal_jual+"|");
			System.out.println("===================================================================");
			}
			}catch(SQLException se){
			se.printStackTrace();
		}
	}

public void updatepenjualan(int data1,int data2) {
		try {
			stmt = conn.createStatement();
			String sql = "UPDATE penjualan SET jumlah_jual ='"+data2+"' WHERE no_nota ='"+data1+"'";
			stmt.executeUpdate(sql);
			System.out.println("Record telah diubah");
		}catch(Exception e){
			System.err.println( "Error ");
		}
	}
	
//CRUD DELETE [tabel penjualan]
public void deletepenjualan(int data1) {
		try {
			stmt = conn.createStatement();
			String sql = "DELETE FROM penjualan WHERE no_nota='"+data1+"'";
			stmt.executeUpdate(sql);
			System.out.println("Record telah dihapus");
		}catch(Exception e){
			System.err.println( "Error ");
		}
	}


	
//================================ BATAS tabel penjualan ========================================

//tampilan menu select CRUD
	public void pilcrud () {
			System.out.println("================================");
			System.out.println("= PENGOLAHAN DATA TABEL DI ATAS=");
			System.out.println("================================");
			System.out.println("=1. TAMBAH RECORD DATA         =");
			System.out.println("=2. UBAH RECORD DATA           =");
			System.out.println("=3. HAPUS RECORD DATA          =");
			System.out.println("=4. KEMBALI MENU UTAMA         =");
			System.out.println("================================");
			System.out.println("= PILIH !!!!!");
	}

	
}
