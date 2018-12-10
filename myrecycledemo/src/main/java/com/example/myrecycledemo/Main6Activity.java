package com.example.myrecycledemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Main6Activity extends AppCompatActivity {
    private final int TITLE_TYPE = 5;
    private final int ADDRESS_TYPE = 6;
    private SparseArray<String> titles = new SparseArray<>();
    private String[] city;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);


        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);

        city = new String[]{"北京", "天津", "上海", "重庆", "石家庄", "唐山", "承德", "秦皇岛", "张家口", "廊坊",
               "保定", "衡水", "沧州", "邢台", "邯郸", "太原", "朔州", "大同", "阳泉", "长治", "晋城", "忻州", "晋中", "临汾",
               "吕梁", "运城", "沈阳", "铁岭", "大连", "朝阳", "抚顺", "本溪", "辽阳", "鞍山", "丹东", "阜新", "营口", "盘锦", "锦州",
               "葫芦岛", "长春", "白城",  "松原", "四平", "辽源", "通化", "白山", "延吉", "图们", "敦化", "珲春", "龙井", "和龙",
               "哈尔滨", "大庆", "牡丹江", "黑河", "七台河", "鹤岗", "伊春", "佳木斯", "双鸭山", "鸡西", "齐齐哈尔", "绥化",
               "南京", "扬州", "苏州", "宿迁", "淮安", "盐城", "徐州", "泰州", "南通", "镇江", "常州", "无锡", "连云港",
               "杭州", "绍兴", "嘉兴", "舟山", "宁波", "湖州", "衢州", "金华", "台州", "温州", "丽水",
               "合肥", "蚌埠", "黄山", "毫州", "阜阳", "宿州", "淮南", "滁州", "马鞍山", "芜湖", "铜陵", "安庆", "淮北", "六安", "巢湖", "池州", "宣城",
               "福州", "厦门", "莆田", "三明", "泉州", "南平", "漳州", "龙岩", "宁德",
               "南昌", "九江", "景德镇", "鹰潭", "新余", "萍乡", "赣州", "上饶", "抚州", "宜春", "吉安",
               "济南", "聊城", "德州", "东营", "淄博", "潍坊", "烟台", "威海", "青岛", "日照", "临沂", "枣庄", "济宁", "泰安", "莱芜", "滨州", "菏泽",
               "郑州", "三门峡", "洛阳", "焦作", "新乡", "鹤壁", "安阳", "濮阳", "开封", "商丘", "许昌", "漯河", "平顶山", "南阳", "信阳", "周口", "驻马店", "济源",
               "武汉", "十堰", "襄樊", "荆门", "孝感", "黄冈", "鄂州", "黄石", "咸宁", "荆州", "宜昌", "随州", "恩施", "利川",
               "长沙", "张家界", "常德", "益阳", "岳阳", "株洲", "湘潭", "衡阳", "郴州", "永州", "邵阳", "怀化", "娄底", "吉首",
               "广州", "清远", "韶关", "河源", "梅州", "潮州", "汕头", "揭阳", "汕尾", "惠州", "东莞", "深圳", "珠海", "中山", "江门", "佛山", "肇庆", "云浮", "阳江", "茂名", "湛江",
               "海口", "三亚", "文昌", "琼海", "万宁", "五指山", "东方", "儋州",
               "成都", "广元", "绵阳", "德阳", "南充", "广安", "遂宁", "内江", "乐山", "自贡", "泸州", "宜宾", "攀枝花", "巴中", "达州", "资阳", "眉山", "雅安", "西昌",
               "贵阳", "六盘水", "遵义", "安顺", "毕节", "铜仁", "凯里", "福泉", "兴义",
               "昆明", "曲靖", "玉溪", "保山", "昭通", "丽江", "思茅", "临沧", "潞西", "瑞丽", "大理", "楚雄", "个旧", "开远", "景洪",
               "西安", "延安", "铜川", "渭南", "咸阳", "宝鸡", "汉中", "榆林", "安康", "商洛",
               "兰州", "嘉峪关", "金昌", "白银", "天水", "武威", "酒泉", "张掖", "庆阳", "平凉", "定西", "陇南", "临夏", "合作",
               "西宁", "德令哈", "格尔木",
               "呼和浩特", "包头", "乌海", "赤峰", "通辽", "呼伦贝尔", "鄂尔多斯", "乌兰察布", "巴彦淖尔", "乌兰浩特", "阿尔山", "锡林浩特", "二连浩特",
               "南宁", "桂林", "柳州", "梧州", "贵港", "玉林", "钦州", "北海", "防城港", "崇左", "百色", "河池", "来宾", "贺州",
               "拉萨", "日喀则",
               "银川", "石嘴山", "吴忠", "固原", "中卫",
               "乌鲁木齐", "克拉玛依", "喀什", "阿克苏", "和田", "吐鲁番", "哈密", "阿图什", "博乐", "昌吉", "库尔勒", "伊宁", "塔城", "阿勒泰",
               "香港", "澳门",
               "台湾"};


        GridLayoutManager manager = new GridLayoutManager(this, 3);
        rv.setLayoutManager(manager);
        rv.setHasFixedSize(true);
        ProbeAdapter probeAdapter = new ProbeAdapter();
        probeAdapter.addTitle(0, "直辖市");
        probeAdapter.addTitle(5, "河北省");
        probeAdapter.addTitle(17, "山西省");
        probeAdapter.addTitle(29, "辽宁省");
        probeAdapter.addTitle(44, "吉林省");
        probeAdapter.addTitle(58, "黑龙江省");
        probeAdapter.addTitle(71, "江苏省");
        probeAdapter.addTitle(85, "浙江省");
        probeAdapter.addTitle(97, "安徽省");
        probeAdapter.addTitle(115, "福建省");
        probeAdapter.addTitle(125, "江西省");
        probeAdapter.addTitle(137, "山东省");
        probeAdapter.addTitle(155, "河南省");
        probeAdapter.addTitle(174, "湖北省");
        probeAdapter.addTitle(189, "湖南省");
        probeAdapter.addTitle(204, "广东省");
        probeAdapter.addTitle(226, "海南省");
        probeAdapter.addTitle(235, "四川省");
        probeAdapter.addTitle(255, "贵州省");
        probeAdapter.addTitle(265, "云南省");
        probeAdapter.addTitle(281, "陕西省");
        probeAdapter.addTitle(292, "甘肃省");
        probeAdapter.addTitle(307, "青海省");
        probeAdapter.addTitle(311, "内蒙古自治区");
        probeAdapter.addTitle(325, "广西壮族自治区");
        probeAdapter.addTitle(340, "西藏自治区");
        probeAdapter.addTitle(343, "宁夏回族自治区");
        probeAdapter.addTitle(349, "新疆维吾尔族自治区");
        probeAdapter.addTitle(364, "特别行政区");
        probeAdapter.addTitle(367, "地区");
        rv.setAdapter(probeAdapter);
    }



    class ProbeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        private  LayoutInflater inflater;

        public ProbeAdapter(){
            inflater = LayoutInflater.from(getApplicationContext());
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
            if (getItemViewType(i) == TITLE_TYPE) {
                View v = inflater.inflate(R.layout.progridviewtitle_item, parent, false);
                TitleHolder titleHolder = new TitleHolder(v);
                return titleHolder;
            }
            if (getItemViewType(i) == ADDRESS_TYPE) {
                View v = inflater.inflate(R.layout.progridview_item, parent, false);
                AddressHolder addressHolder = new AddressHolder(v);
                return addressHolder;
            }
            return null;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
            if (getItemViewType(position) == TITLE_TYPE) {
                TitleHolder titleViewHolder = (TitleHolder) viewHolder;
                titleViewHolder.tv_titie.setText(titles.get(position));
            }
            if (getItemViewType(position) == ADDRESS_TYPE) {

                for (int i = 0; i < titles.size(); i++) {
                    int key = titles.keyAt(i);
                    if (position > titles.keyAt(titles.size() - 1)) {
                        position -= titles.size();
                        break;
                    } else if (position > key && position < titles.keyAt(i + 1)) {
                        position -= (i + 1);
                        break;
                    }

                }
                final int s = position;
                AddressHolder myViewHolder = (AddressHolder) viewHolder;
                myViewHolder.tv_titie.setText(city[s]);
            }
        }

        @Override
        public int getItemCount() {
            return (city.length + titles.size());
        }


        private void addTitle(int position, String title) {
            titles.put(position, title);
        }

        private boolean isTitle(int position) {
//        return titles.get(position) == null ? false : true;
            return titles.get(position) != null;
        }

        @Override
        public int getItemViewType(int position) {
            if (isTitle(position)) {
                return TITLE_TYPE;
            }
            return ADDRESS_TYPE;
        }

        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            //如果是title就占据2个单元格(重点)
            GridLayoutManager manager = (GridLayoutManager) recyclerView.getLayoutManager();
            manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if (isTitle(position)) {
                        return 3;
                    }
                    return 1;
                }
            });
        }
    }
    class TitleHolder extends RecyclerView.ViewHolder{

        private final TextView tv_titie;

        public TitleHolder(View itemView) {
            super(itemView);
            tv_titie = itemView.findViewById(R.id.tv_title);
        }
    }

    class AddressHolder extends RecyclerView.ViewHolder{
        private final TextView tv_titie;
        public AddressHolder(View itemView) {
            super(itemView);
            tv_titie = itemView.findViewById(R.id.tv_probe_address);
        }
    }
}
