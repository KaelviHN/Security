package cn.anran.security;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@SpringBootTest
class SecurityApplicationTests {

    /**
     * $2a$10$wQGt71M1NCMtkHW.c5zP/e4xgsve0yRVURYgclN39058ZcZXe6dJy
     */
    @Test
    void contextLoads() {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        System.out.println(bCryptPasswordEncoder.encode("123456"));
        PasswordEncoder delegatingPasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        System.out.println("{pbkdf2}"+delegatingPasswordEncoder.encode("123456"));
    }

    @Test
    public void test(){
        Set<String> n1 = Set.of(
                "ACBNews", "DaZhong", "HKCNA", "MoDaily", "SinaMobile", "WAOU",
                "AMCM", "DCJJ", "HKET", "NeiMengGuNews", "Sohu", "WenWeiPo",
                "AnHuiNews", "DongBeiNews", "HKGolden", "NHK", "SouthCN", "WorldNews",
                "AoMenJiJinNews", "DongFangNews", "HL", "NTES", "SPUTNIK", "XinHuaNews",
                "BJNews", "EEO", "HongKong01", "NXNews", "STCN", "XinLangMeiGuNews",
                "CaiJing", "EnorthNews", "HongKongJingRongNews", "Oeeee", "STNN", "XZNews",
                "CCTV", "Exmoo", "HongKongTongjiNews", "OrientalDaily", "SXRB", "YCWB",
                "CECN", "FengHuangHuang", "HuaLongNews", "OuShiNet", "TaiChungDaily", "YiCai",
                "CENA", "FenghuangNews", "HuXiu", "OXFAM", "TaiDu", "YiDaiYiLuNews",
                "ChinaDaily", "FJSEN", "Jornalvakio", "PengpaiNews", "TaiWanChanJingNews",
                "YNDaily", "ChinaDailyNews", "FOCAC", "JSChina", "PepoleNews", "TakungPao",
                "YouthNews", "ChinaNews", "FortuneChina", "JXNews", "PhHua", "TaKungPao",
                "ZaoBao", "ChinaTongXinNews", "GcsGovMo", "KyoDoNews", "PingWest", "TDM",
                "ZhongHua", "ChinesePress", "GcsGovMoMac", "MacaoBusinessNews", "QHNews",
                "TechWeb", "ZhongXinJingWeiNews", "CNHuBei", "GSCN", "MacauBusiness",
                "QianLongNews", "Tencent", "ZiJing", "CNJiWang", "GuanchaNews",
                "MacauPostDaily", "RedNet", "TengXunNews", "ZiJingNews", "CNR", "GXNews",
                "MeiRiEconomicNews", "RTHK", "TWNews", "ZJNews", "CRI", "HeXun", "MHWMM",
                "SCMP", "VOC", "ZLBGov", "CRNTT", "HKBU", "MingPao", "SiChuan",
                "WaiJiaoBuNews", "CSNews", "HKCD", "MK", "Sina", "WangYiNews"
        );
        System.out.println(n1.size());
        List<String> n2 = Arrays.asList(
                "ACBNews", "CSNews", "JapenEconomicNews", "PhHua", "Time",
                "AisiaPeriodNews", "DaZhong", "Jornalvakio", "PingWest", "TS",
                "AM730", "DCJJ", "JSChina", "PolYu", "TVBS",
                "AMCM", "DongBeiNews", "JXNews", "QHNews", "TWNews",
                "AnHuiNews", "DongFangNews", "KWongWah", "QianLongNews", "UDN",
                "AoMenJiJinNews", "DouTiaoNews", "KyoDoNews", "RedNet", "UDNBKK",
                "AoMenTongJiNews", "DPPNews", "LineToday", "RenminRiBaoNews", "UpMedia",
                "BackChina", "DWNews", "LiteratureCity", "RFI", "VOAChinese",
                "BastillePost", "EEO", "liuyuan", "RTHK", "VOC",
                "BBC", "EnorthNews", "LOCPGHK", "SCMP", "WaiJiaoBuNews",
                "BcBayNews", "ETToday", "LTN", "WallStreetCN",
                "BeijingSpring", "Exmoo", "MacaoBusinessNews", "SecretChina", "WangYiNews",
                "BJNews", "FengHuangHuang", "MacauBusiness", "SentinelAsia", "WAOU",
                "BoTanWang", "FenghuangNews", "MacauDailTimes", "SiChuan", "WenWeiPo",
                "BoXun", "FJSEN", "MacauPostDaily", "Sina", "WorldDailyNews",
                "BusinessWeekly", "FOCAC", "MediaEight", "SinaMobile", "WorldJournal",
                "Ca51", "FortuneChina", "MeiRiEconomicNews", "SinCheW", "WorldNews",
                "CaiJing", "FreedomAsianNews", "MetroRadio", "Sohu", "XingDaoRiNews",
                "CCTV", "GcsGovMo", "MHWMM", "SouthCN", "XinHuaNews",
                "CDN", "GcsGovMoMac", "MingBaoJiaXiNews", "SouthSeaNews", "XinLangMeiGuNews",
                "CDNS", "GMW", "MingPao", "SPUTNIK", "XZNews",
                "CECN", "GSCN", "MK", "YaHoo",
                "CENA", "GuanchaNews", "MoDaily", "STCN", "YaHooXiangGang",
                "ChinaDaily", "GXNews", "NanFeiChineseNews", "STHeadLine", "YAM",
                "ChinaDailyNews", "HeXun", "NeiMengGuNews", "STNN", "YCWB",
                "ChinaNews", "HKBU", "NewTalk", "STORM", "YiCai",
                "ChinaPress", "HKCD", "NHK", "SXRB", "YiDaiYiLuNews",
                "ChinaTimes", "HKCNA", "TaiChungDaily", "YinTaiFuWuNews",
                "ChinaTongXinNews", "HKEJ", "NowNews", "TaiDu", "YNDaily",
                "ChinesePress", "HKET", "NTES", "TaiWanChanJingNews", "YouthNews",
                "ChoSun", "HKGolden", "NXNews", "TakungPao", "ZaoBao",
                "CitYu", "HL", "Oeeee", "TaKungPao", "ZhongHua",
                "CNA", "HongKong01", "OrientalDaily", "TDM", "ZhongXinJingWeiNews",
                "CNHuBei", "HongKongHerald", "OuShiNet", "TechWeb", "ZhongYangGuangBoNews",
                "CNJiWang", "HongKongJingRongNews", "Tencent", "ZiJing",
                "CNR", "HongKongTongjiNews", "OXFAM", "TengXunNews", "ZiJingNews",
                "HowBuy", "PassionTimes", "TheGreatWall", "ZJNews",
                "HuaLongNews", "PCHome", "Theinitium", "ZLBGov",
                "CRI", "HuanQiu", "PengpaiNews", "TheNewsLens",
                "CRNTT", "HuXiu", "PepoleNews", "TheStandard"
        );
        System.out.println(n2.size());
        List<String> diff = n2.stream().filter(n1::contains).toList();
        System.out.println(diff);
    }

}
