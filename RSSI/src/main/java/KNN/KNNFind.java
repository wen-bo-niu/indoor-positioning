package KNN;

import Dao.Dao;

import java.util.*;

import static KNN.StrUtil.similarityRatio;

public class KNNFind {

    List<KNNnode> set=new ArrayList<KNNnode>();
    List<Double> da=new ArrayList<Double>();

    //选出类型最接近的项
    public List<KNNnode> choose(String s){
        Dao dao=new Dao();
        List<KNNnode> n=dao.getInfo();
        for(int i=0;i<n.size();i++) {
            da.add(similarityRatio(n.get(i).getType(),s));
            set.add(new KNNnode(n.get(i).getX(),n.get(i).getY(),n.get(i).getType(),da.get(i)));
        }

        for(int i=0;i<n.size();i++) {
            //Collections.sort(set,Collections.reverseOrder());
            set.sort(Comparator.comparing(KNNnode::getCmp).reversed());
        }

        return set;
    }

}
