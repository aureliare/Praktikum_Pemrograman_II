package tugas7.Membership.src.view.jenismember;

import java.util.List;
import javax.swing.table.*;
import tugas7.Membership.src.model.JenisMember;


public class JenisMemberTableModel extends AbstractTableModel {
    private String[] columnNames = {"Nama"};
    private List<JenisMember> data;

    public JenisMemberTableModel(List<JenisMember> data ){
        this.data = data;
    }


    public int getColumnCount(){
        return columnNames.length;
    }

    public int getRowCount(){
        return data.size();
    }

    public String getColumnName(int col){
        return columnNames[col];
    }

    public Object getValueAt(int row, int col){
        JenisMember jenisMember = data.get(row);
        String value = "";
        switch (col) {
            case 0:
                value = jenisMember.getNama();
                break;
        }

        return value;
    }

    public boolean isCellEditable(int row, int col){
        return false;
    }
    
    public void add(JenisMember value){
        data.add(value);
        fireTableRowsInserted(data.size() -1 , data.size() -1);
    }
}