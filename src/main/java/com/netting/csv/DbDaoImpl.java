package com.netting.csv;


import com.entities.Trade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;


public class DbDaoImpl implements DbDao{

    private String tnsNames;
    private String userName;
    private String password;
    private List<AdaptivTrades> adaptivTradesList = new ArrayList<>();
    private AdaptivTrades adaptivTrades = new AdaptivTrades();
    EntityManager em;

    public DbDaoImpl(EntityManager entityManager){
        this.em =entityManager;
    }

    private void setTnsNames(String tnsNames){
        System.out.println("Setting out tnsnames" + tnsNames);
        this.tnsNames=tnsNames;
    }
    private String getTnsNames(){
        return this.tnsNames;
    }


    @Override
    public List getMatchingTradesFrom(int iceLinkTradeId) {
        return em.createQuery("SELECT c FROM Trade c WHERE c.trade_Id LIKE :iceLinkTradeId")
                .setParameter("iceLinkTradeId", iceLinkTradeId)
                .getResultList();

    /*    Connection connection = getDatabaseConnection();
        System.out.println("Connection established" + getTnsNames());
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            em.createQuery()
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            assert stmt != null;
            ResultSet rs = stmt.executeQuery("SELECT * from trade where trade_Id like '%"+iceLinkTradeId+"%'");
            if (rs.next()) {
                System.out.println(rs.getString("TRADE_ID"));
                System.out.println(rs.getString("TRADE_STATUS_CODE"));
                System.out.println(rs.getString("ENTERED_USER_CODE"));
                adaptivTrades.setAdaptivTradeId(rs.getLong(1));
                adaptivTrades.setInfintyId(1);
                adaptivTradesList.add(adaptivTrades);

            }
        } catch (SQLException e) {
            e.printStackTrace();*/


        //return adaptivTradesList;
    }


    @Override
    public void setDataBaseConnection(String tnsNames, String userName, String password) {
        this.userName=userName;
        this.password=password;
        setTnsAdmin();
        this.tnsNames = String.format("jdbc:oracle:thin:@%s", tnsNames);
        setTnsNames(this.tnsNames);
        try {
            Class.forName ("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void setTnsAdmin() {
        String tnsAdmin = System.getenv("TNS_ADMIN");
        String fullOraclePath = null;
        if (tnsAdmin == null) {
            String oracleHome = System.getenv("ORACLE_HOME");
            if (oracleHome == null) {
                String path = System.getenv("PATH");
                if(path == null) {
                    System.out.println("No TNS ADMIN");
                    return;
                }else{
                    fullOraclePath = getOraPath(path);
                    System.out.println(fullOraclePath);
                }
            }
            //tnsAdmin = oracleHome + File.separatorChar + "network" + File.separatorChar + "admin";
            tnsAdmin = fullOraclePath;
        }
        assert tnsAdmin != null;
        System.setProperty("oracle.net.tns_admin", tnsAdmin);
    }

    private static String getOraPath(String path) {
        if (path.contains("oracle")){
            String[]p=path.split(";");
            return p[0].replace("bin","network\\admin");
        }
        return null;
    }

    public static void main(String[] arg){
        EntityManagerFactory emf;
        EntityManager em;
        emf = Persistence.createEntityManagerFactory("primary");
        em = emf.createEntityManager();
    //    new DbDaoImpl(em).setDataBaseConnection("TIPT2.WORLD","G91326","infinity");

        List o = new DbDaoImpl(em).getMatchingTradesFrom(500001);

        Trade t = (Trade) o;
        System.out.println(t.getRemark());

        System.out.println(new DbDaoImpl(em).getMatchingTradesFrom(500001));
        em.close();

    }
}
