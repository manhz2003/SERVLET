package database;

import model.tacGia;

import java.util.ArrayList;

public class tacGiaDAO {
    private ArrayList<tacGia> data = new ArrayList<tacGia>();
    private ArrayList<tacGia> selectAll(){
        return  data;
    }

    private tacGia selectById (String id){
        tacGia result = null;
        tacGia tim = new tacGia();
        tim.setMaTacGia(id);
        for (tacGia tacGia : data) {
            if (tacGia.equals(tim)){
                return tacGia;
            }
        }
        return null;
    }

    private int insert (tacGia tg){
        tacGia kiemTraTonTai = this.selectById(tg.getMaTacGia());
        if(kiemTraTonTai == null) {
            data.add(tg);
            return 1;
        }else {
        }return 0;
    }

    private int insertAll (ArrayList<tacGia> list){
        int dem = 0;
        for (tacGia tacGia : list) {
            dem += this.insert(tacGia);
        }
        return dem;
    }

    private int delete (tacGia tg){
        tacGia kiemTraTonTai = this.selectById(tg.getMaTacGia());
        if(kiemTraTonTai != null) {
            data.remove(tg);
            return 1;
        }else {
        }return 0;
    }


}
