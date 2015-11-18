/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnswerModule;

import DatabaseModule.Database;

import AnswerModule.Answer;
import IdentityServiceModule.IdentityService;

import java.sql.*;
import java.util.ArrayList;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author LUCKY
 */
@WebService(serviceName = "AnswerWS")
@Stateless()
public class AnswerWS {

    @WebMethod(operationName = "GetAllAnswer")
    public ArrayList<Answer> GetAllAnswer(){//tambah author name 
        Database DB = new Database();
        Connection con = DB.connect();
        
        ArrayList<Answer> Answers = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            String query = "SELECT * FROM Answer NATURALJOIN UAccount";
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()){
                Answers.add(new Answer(rs.getInt("aid"),rs.getInt("qid"),rs.getString("Email"),rs.getString("AuthorName"),rs.getString("Content"),rs.getInt("vote"),rs.getString("created at")));
            }
            rs.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                if(stmt!=null) con.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            try{
                if(con!=null) con.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return Answers;
    }
    
    @WebMethod(operationName = "InsertAnswer")
    public void InsertAnswer(@WebParam(name="access_token")String access_token,@WebParam(name="qid")int qid, @WebParam(name="content")String content){//aid qid content token 
        Database DB = new Database();
        Connection con = DB.connect();
        
        PreparedStatement ps = null;
        try{
            String query = "INSERT INTO Answer (qid,Email,Content) VALUES (?,?,?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, qid);
            ps.setString(2, IdentityService.getEmail(access_token));
            ps.setString(3, content);
            ps.executeUpdate();
            ps.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                if (ps!=null) con.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            try{
                if (con!=null) con.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    @WebMethod(operationName = "UpdateAnswer")
    public void UpdateAnswer(@WebParam(name="access_token") String access_token, @WebParam(name="content")String content, @WebParam(name="aid")int aid){
        Database DB = new Database();
        Connection con = DB.connect();
        
        PreparedStatement ps = null;PreparedStatement checkps=null;
        try{
            //cek apakah email sama
            String checkquery = "SELECT Email FROM Answer WHERE aid = ?";
            checkps = con.prepareStatement(checkquery);
            checkps.setInt(1, aid);
            ResultSet selRes = checkps.executeQuery();
            String Email=IdentityService.getEmail(access_token); //TODO tangkap error kalau tidak ada
            if (selRes.next()){
                if (Email.equals(selRes.getString("Email"))){
                    String query ="UPDATE Answer SET Content = ? WHERE aid = ?" ;
                    ps = con.prepareStatement(query);
                    ps.setString(1, content);
                    ps.setInt(2, aid);
                    ps.executeUpdate();
                    ps.close();
                }else{
                    //TODO throw error unauthorized
                }
            }else{
                //TODO throw error
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                if (ps!=null) checkps.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            try{
                if (checkps!=null) checkps.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            try{
                if (con!=null) con.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    @WebMethod(operationName = "DeleteAnswer")
    public void DeleteAnswer(@WebParam(name="aid")int aid){
        Database DB = new Database();
        Connection con = DB.connect();
        
        PreparedStatement ps = null;
        try{
            String query = "DELETE FROM ANSWERS WHERE aid = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, aid);
            ps.executeQuery();
            ps.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                if (ps!=null) con.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            try{
                if (con!=null) con.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
}
