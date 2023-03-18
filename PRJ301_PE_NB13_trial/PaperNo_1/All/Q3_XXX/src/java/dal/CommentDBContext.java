/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Comment;
import model.Thread1;

/**
 *
 * @author Nguyen Hoang Minh
 */
public class CommentDBContext extends DBContext{
    public ArrayList<Comment> all(){
        ArrayList<Comment> comments = new ArrayList<>();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT cid,ctitle,c.userid,c.tid,a.displayname,t.tcontent FROM Comment c\n" +
"inner join Account a on c.userid=a.userid\n" +
"inner join Thread t on c.tid = t.tid";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Comment c = new Comment();
                c.setId(rs.getInt("cid"));
                c.setTitle(rs.getString("ctitle"));
                Account a = new Account();
                Thread1 t = new Thread1();
                a.setUsername(rs.getString("userid"));
                a.setDisplayname(rs.getString("displayname"));
                t.setId(rs.getInt("tid"));
                t.setComment(rs.getString("tcontent"));
                c.setAccount(a);
                c.setThread(t);
                comments.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(ThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return comments;
    }
    public void insert(Comment model) {
        PreparedStatement stm = null;
        try {
            String sql = "INSERT INTO Comment(ctitle,tid,userid) values (?,?,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, model.getTitle());
            stm.setInt(2, model.getThread().getId());
            stm.setString(3, model.getAccount().getUsername());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ThreadDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
