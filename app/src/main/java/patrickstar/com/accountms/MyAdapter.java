package patrickstar.com.accountms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import java.util.List;
import patrickstar.com.accountms.model.tb_flag;
import patrickstar.com.accountms.model.tb_inaccount;
import patrickstar.com.accountms.model.tb_outaccount;

/**
 * Created by ios24 on 17/9/4.
 */

public class MyAdapter extends BaseAdapter {

    public List<tb_inaccount> iData;
    public List<tb_outaccount> oData;
    public List<tb_flag> fData;
    public int  temp ;
    //public List<InfoContent> flagData;

    private LayoutInflater mInflater;
    public MyAdapter(Context context, List list,int i ){
        this.mInflater = LayoutInflater.from(context);
          temp=i;
       switch (temp){
           case 0: iData = list;break;
           case 1: oData = list;break;
           case 2: fData = list;break;
       }

    }

    @Override
    public int getCount() {
        //mData = baseAdapterDemo.getData();
        if(temp==1){
            return oData.size();
        }
        else if(temp==0){
            return iData.size();
        }
        else{
            return fData.size();
        }
    }
    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(temp==0){
            ViewHolder holder = null;
            if(view == null){
                holder =new ViewHolder();
                view = mInflater.inflate(R.layout.item1,null);//加载布局文件
                holder.type = view.findViewById(R.id.content);
                view.setTag(holder);

            }
            else{
                holder = (ViewHolder) view.getTag();
            }



        tb_inaccount  inaccount  = (tb_inaccount) iData.get(i);
        holder.type.setText((String)iData.get(i).getType());
        //holder.chk.setChecked(mData.get(i).isChk());
        return  view;
        }
        else if(temp ==1){

            ViewHolder holder = null;
            if(view == null){
                holder =new ViewHolder();
                view = mInflater.inflate(R.layout.item1,null);//加载布局文件
                holder.type = view.findViewById(R.id.content);
                view.setTag(holder);

            }
            else{
                holder = (ViewHolder) view.getTag();
            }



            tb_outaccount  inaccount  = (tb_outaccount) oData.get(i);
            holder.type.setText((String)iData.get(i).getType());
            //holder.chk.setChecked(mData.get(i).isChk());
            return  view;

        }else {
            ViewHolder holder = null;
            if(view == null){
                holder =new ViewHolder();
                view = mInflater.inflate(R.layout.item1,null);//加载布局文件
                holder.type = view.findViewById(R.id.content);
                view.setTag(holder);

            }
            else{
                holder = (ViewHolder) view.getTag();
            }

            tb_flag flag  = (tb_flag) fData.get(i);
            holder.type.setText((String)fData.get(i).getFlag());
            //holder.chk.setChecked(mData.get(i).isChk());
            return  view;

        }
    }

    public final class ViewHolder {
        public TextView type;

    }
}
