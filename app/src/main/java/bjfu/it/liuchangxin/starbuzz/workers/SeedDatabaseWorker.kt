package bjfu.it.liuchangxin.starbuzz.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import bjfu.it.liuchangxin.starbuzz.R
import bjfu.it.liuchangxin.starbuzz.data.Category
import bjfu.it.liuchangxin.starbuzz.data.Commodity
import bjfu.it.liuchangxin.starbuzz.data.StarbuzzDatabase
import kotlinx.coroutines.coroutineScope

class SeedDatabaseWorker(appContext: Context, params: WorkerParameters) :
    CoroutineWorker(appContext, params) {
    override suspend fun doWork(): Result = coroutineScope {
        try {
            populate(StarbuzzDatabase.getInstance(applicationContext))
            Result.success()
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.failure()
        }
    }

    companion object {
        private const val TAG = "SeedDatabaseWorker"
    }

    private suspend fun populate(db: StarbuzzDatabase) {
        val commodityDao = db.commodityDao()
        commodityDao.insertAll(
            listOf(
                Commodity(
                    Category.DRINK,
                    "Cappuccino",
                    14.9,
                    R.drawable.cappuccino,
                    "A cappuccino is an espresso-based coffee drink that originated in Italy, and is traditionally prepared with steamed milk foam. Variations of the drink involve the use of cream instead of milk, using non-dairy milks, and flavoring with cinnamon or chocolate powder.\n\nOutside of Italy, cappuccino is a coffee drink that today is typically composed of a single espresso shot and hot milk, with the surface topped with foamed milk.[2] Cappuccinos are most often prepared with an espresso machine. The double espresso is poured into the bottom of the cup, followed by a similar amount of hot milk, which is prepared by heating and texturing the milk using the espresso machine steam wand. The top third of the drink consists of milk foam; this foam can be decorated with artistic drawings made with the same milk, called latte art.\n\nIn a traditional cappuccino, as served in Europe and artisan coffee houses in the United States, the total of espresso and milk/foam make up between approximately 150 and 180 ml (5 and 6 imp fl oz; 5 and 6 US fl oz). Commercial coffee restaurant chains in the US more often serve the cappuccino as a 360 ml (13 imp fl oz; 12 US fl oz) drink or larger. In Italy, a cappuccino consists of 25 ml (1 imp fl oz; 1 US fl oz) of espresso; the rest of the cup is filled with equal parts of milk and foam.[7][8] Outside of Italy, the ratios of espresso, milk, and foam typically equal 1/3 each."
                ),
                Commodity(
                    Category.DRINK,
                    "Filter",
                    17.0,
                    R.drawable.filter,
                    "filter coffee is a coffee drink made by mixing frothed and boiled milk with the infusion obtained by percolation brewing of finely ground coffee powder in a traditional Indian filter. The drink known as Kaapi, is the South Indian phonetic rendering of \"coffee\"\n\nPopular Indian lore says that on a pilgrimage to Mecca in the 16th century Baba Budan, a revered Sufi saint from Karnataka state, discovered the wonders of coffee. Eager to grow coffee at home, he smuggled seven coffee beans from the Yemeni port of Mocha in his garments. Returning home, he planted the beans on the slopes of the Chandragiri Hills in Chickmagaluru district, Mysore State (present-day Karnataka). This hill range was later named after him as the Baba Budan Hills. His tomb is near Chikmagalur.[1]\n\nSouth Indian filter coffee is brewed with a metal device that resembles two cylindrical cups, one of which has a pierced bottom that nests into the top of the 'tumbler' cup, leaving ample room beneath to receive the brewed coffee. The upper cup has two removable parts: a pierced pressing disc with a central stem handle and a covering lid. (A similar device is used to brew Vietnamese coffee.)"
                ),
                Commodity(
                    Category.DRINK,
                    "Latte",
                    12.9,
                    R.drawable.latte,
                    "Caffe latte is a coffee drink made with espresso and steamed milk. The word comes from the Italian caffè e latte, caffelatte or caffellatte, which means \"coffee & milk\".  The word is also sometimes spelled latté or lattè in English with different kinds of accent marks, which can be a hyperforeignism or a deliberate attempt to indicate that the word is not pronounced according to the rules of English orthography.\n\nIn northern Europe and Scandinavia, the term café au lait has traditionally been used for the combination of espresso and milk. In France, café latte is mostly known from the original Italian name of the drink (caffè latte or caffelatte); a combination of espresso and steamed milk equivalent to a \"latte\" is in French called grand crème and in German Milchkaffee or (in Austria) Wiener Melange.\n\nVariants include the chocolate-flavored mocha or replacing the coffee with another drink base such as masala chai (spiced Indian tea), mate, matcha, turmeric or rooibos; other types of milk, such as soy milk or almond milk, are also used.\n\nCoffee and milk have been part of European cuisine since the 17th century. Caffè e latte, Milchkaffee, café au lait and café con leche are domestic terms of traditional ways of drinking coffee, usually as part of breakfast in the home. Public cafés in Europe and the US seem to have no mention of the terms until the 20th century, although Kapuziner is mentioned in Austrian coffee houses in Vienna and Trieste in the 2nd half of 1700s as \"coffee with cream, spices and sugar\" (being the origin of the Italian cappuccino)."
                ),
                Commodity(
                    Category.DRINK,
                    "乌龙茶",
                    15.5,
                    R.drawable.wulongcha,
                    "乌龙茶（oolong tea），亦称青茶、半发酵茶及全发酵茶，品种较多，是中国几大茶类中，独具鲜明中国特色的茶叶品类。乌龙茶是经过采摘、萎凋、摇青、炒青、揉捻、烘焙等工序后制出的品质优异的茶类。\n\n乌龙茶由宋代贡茶龙团、凤饼演变而来，创制于1725年（清雍正年间）前后。品尝后齿颊留香，回味甘鲜。乌龙茶的药理作用，突出表现在分解脂肪、减肥健美等方面。在日本被称之为“美容茶”、“ 健美茶”。乌龙茶为中国特有的茶类，主要产于福建的闽北、闽南及广东、台湾三个省。四川、湖南等省也有少量生产。乌龙茶除了内销广东、福建等省外，主要出口日本、东南亚和港澳地区。主要生产地区是福建省安溪县等地。\n\n《闽通志》载，唐末建安张廷晖雇工在凤凰山开辟山地种茶，初为研膏茶，宋太宗太平兴国二年(977年)已产制龙凤茶，宋真宗(998年)以后改造小团茶，成为名扬天下的龙团凤饼。当时任过福建转运吏，监督制造贡茶的蔡襄，特别称颂北苑茶，他在1051年写的《茶录》中谈到“茶味主于甘滑，惟北苑凤凰山连续诸焙所产者味佳。”北苑茶重要成品属于龙团凤饼，其采制工艺如皇甫冉送陆羽的采茶诗里所说：“远远上层崖，布叶春风暖，盈筐白日斜。”要采得一筐的鲜叶，要经过一天的时间，叶子在筐子里摇荡积压，到晚上才能开始蒸制，这种经过积压的原料无意中就发生了部分红变，芽叶经酶促氧化的部分变成了紫色或褐色，究其实质已属于半发酵了，也就是所谓乌龙茶的范畴。因此，说北苑茶是乌龙茶的前身是有一定科学根据。"
                ),
                Commodity(
                    Category.DRINK,
                    "可乐",
                    5.0,
                    R.drawable.kele,
                    "可乐(Cola)，是指有甜味、含咖啡因但不含酒精的碳酸饮料，非常流行。可乐主要口味包括有香草、肉桂、柠檬香味等。名称来自可乐早期的材料之一：可乐果提取物，最知名的可乐品牌有可口可乐和百事可乐。\n\n喝可乐本来是跟喝其他饮料没什么差别的消费行为。但是，可乐文化，其内涵太丰富了，远远超出了“喝饮料”的范畴。\n\n可乐的主要配方是公开的。为了纪念可口可乐在1986年的100年生日，古斯坦把这种新的配方命名为“7×100”。配料为糖、碳酸水（二氧化碳和水）、焦糖、磷酸、咖啡因等。正是这种香料混合剂，奠定了可乐的独特品味。欧洲的食品专家们经过长期的研究，认为“7X”的组成包括：野豌豆，生姜、含羞草、橘子树叶、古柯叶、桂树和香子兰皮等的提炼物或过滤物。在不同国家和地区内，可乐的配方不会完全相同，含有地方特色的配料成分有助于适应各地顾客的品味。\n\n可乐是一种美国文化的阐述，是一种美国精神的扩张。这是“两乐”虽历经沧桑依然挺拔的根本原因。而这一点，任何国内品牌是无法比拟的。"
                ),
                Commodity(
                    Category.DRINK,
                    "红牛",
                    9.9,
                    R.drawable.hongniu,
                    "1995年12月，“红牛”凭着对中国市场发展的信心和全球战略眼光，从泰国来到中国，成立了红牛维他命饮料有限公司（下称红牛公司），大力开拓中国市场。二十余年来，红牛维他命饮料有限公司建立了覆盖全国的销售网络及机构。秉承国际先进经营理念和管理模式，重在引导和培养消费观念，以“功能饮料市场先入者”的地位和优势，红牛饮料快速打开中国市场，逐步发展成为中国饮料行业的领军品牌。\n\n“红牛”一词的来历，可以参考James G. Frazer的人类学经典《金枝》第三章第二节有这样一句话的描述：“ 在古希腊，任何男人如果被误认为已经死亡而且在形式上为他举行过葬礼，那么除非让他经过下述重新诞生的仪式，不然，他就仍将被社会当成已故的人对待。该仪式的过程是：他得从一个女人的衣裙下钻过，然后洗净全身，裹在襁褓中送给奶妈。在这些仪式没有认真履行之前，他不得在活人中活动。顺势巫术的另一个良善的用途是防治病痛。\n\n古代印度人为了治愈黄疸病，根据顺势巫术原则举行一次精心安排的仪式，其要旨是想要把黄颜色从病人身上转移给通常是带黄色的牲畜或别的东西（如太阳光），并且把健康的红颜色从一个活跃的、生命力旺盛的红牛身上转移给病人。顺势巫术的一个很大的优点在于，治病过程可以在医生身上而不必在病人身上进行和完成，只要患者看到他的医生在他面前装作极度痛苦的样子在地上打滚，于是他就解除了所有的病痛和麻烦。”由此选段可以看出，“红牛”是一种活跃的、生命力旺盛的表现。"
                ),
                Commodity(
                    Category.DRINK,
                    "白酒",
                    29.9,
                    R.drawable.baijiu,
                    "白酒（外文名：Liquor and Spirits [1]  ，Baijiu [2]  ），是中国酒类（除了果酒、米酒外）的统称，又称烧酒、老白干、烧刀子等。\n\n中国白酒具有以酯类为主体的复合香味，以曲类、酒母为糖化发酵剂，利用淀粉质（糖质）原料，经蒸煮、糖化、发酵、蒸馏、陈酿和勾兑而酿制而成的各类酒。而严格意义上讲，由食用酒精和食用香料勾兑而成的配制酒则不能算做是白酒。白酒主集中在长江上游和赤水河流域的贵州仁怀、四川宜宾、四川泸州三角地带有着全球规模最大、质量最优的蒸馏酒产区，分别为中国三大名酒 [3]  的茅五泸，其白酒产业集群扛起中国白酒产业的半壁河山。\n\n酒中醛类是分子大小相应的醇的氧化物，也是白酒发酵过程中产生的。低沸点的醛类有甲醛、乙醛等，高沸点的醛类有糠醛、丁醛、戊醛、己醛等。醛类的毒性大于醇类，其中毒性较大的是甲醛，毒性比甲醇大30倍左右，是一种原生质毒物，能使蛋白质凝固，10克甲醛可使人致死。在发生急性中毒时，出现咳嗽、胸痛、灼烧感、头晕、意识丧失及呕吐等现象。"
                ),
                Commodity(
                    Category.DRINK,
                    "高粱酒",
                    39.9,
                    R.drawable.gaoliangjiu,
                    "高粱酒高粱是生产白酒的主要原料。以高粱酿造白酒，我国独步世界，久享盛名。高粱白酒以其色、香、味和风格展现了我国酒文化的深厚底蕴。\n\n金门酒厂所生产的产品包括金门高粱酒、58度金门高粱酒、38度金门高粱酒、28度金门高粱酒、纪念系列金门高粱酒。其中以58度金门高粱酒最为普遍，俗称“白金龙”，深受消费者喜爱，年销量高达二千万瓶以上。\n\n在消费特征方面，渔家有着畅饮的豪气，到了金门，豪爽的金门人不仅晚宴上用高度的白酒频频和你碰杯，午宴上也必定摆出白金龙高粱酒与客人痛饮。纯正的金门高粱酒，晶莹剔透，清香扑鼻，一口入嘴，甘醇爽口，齿颊留香，久久不散。尝到酒香后，人们似乎慢慢上瘾了，不分中午晚上，有酒就喝。\n\n台湾金门高粱酒之香、纯、甘、冽原味，由舌尖入喉，真实原味、清香恣意散发，豪情的纯饮将能品酌出金门高粱酒的道地风味。送礼自用两相宜、并作为为佳节最佳伴手礼。"
                ),
                Commodity(
                    Category.DRINK,
                    "玉米汁",
                    19.9,
                    R.drawable.yumizhi,
                    "玉米汁汁饮料是一种以玉米为主要原料的营养保健型饮料，生产工艺简单，成本低，风味清香可口，适合于男女老少饮用，具有很大的市场潜力。\n\n其主要特点是：不需胃酸分解，可直接被肠道吸收，更能满足人体营养平衡的需要，上述多种营养物质的组合使本品具有提高大脑细胞活力、提高记忆力、促进生长发育、增强有益菌、抑制有害菌、防止细胞老化、延缓衰老、防癌抗癌等特殊保健作用。\n\n含丰富膳食纤维、可防肠炎、肠癌等、能降低胆固醇、预防高血压和冠心病、常食皮肤细嫩光滑、延缓皱纹。"
                ),
                Commodity(
                    Category.FOOD,
                    "Hamburger",
                    22.9,
                    R.drawable.hamburger,
                    "A hamburger is a sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun. The patty may be pan fried, grilled, smoked or flame broiled.\n\nThe term \"burger\" can also be applied to the meat patty on its own, especially in the United Kingdom, where the term \"patty\" is rarely used, or the term can even refer simply to ground beef. Since the term hamburger usually implies beef, for clarity \"burger\" may be prefixed with the type of meat or meat substitute used, as in beef burger, turkey burger, bison burger, or veggie burger.\n\nHamburgers are sold at fast-food restaurants, diners, and specialty and high-end restaurants (where burgers may sell for several times the cost of a fast-food burger, but may be one of the cheaper options on the menu). There are many international and regional variations of the hamburger."
                ),
                Commodity(
                    Category.FOOD,
                    "火腿肠",
                    5.5,
                    R.drawable.huotuichang,
                    "\n\n火腿肠（英语：ham sausage）是深受广大消费者喜爱的一种肉类加工食品，它是以畜禽肉为主要原料，辅以填充剂（淀粉、植物蛋白粉等），然后再加入调味品（食盐、糖、酒、味精等）、香辛料（葱、姜、蒜、豆蔻、砂仁、大料、胡椒等）、品质改良剂（卡拉胶、Vc等）、护色剂、保水剂、防腐剂等物质，采用腌制、斩拌（或乳化）、高温蒸煮等加工工艺制成，它的特点是肉质细腻、鲜嫩爽口、携带方便、食用简单、保质期长。\n\n在食品工程里，火腿肠是一种被称为“乳化肉”的体系。它的关键是把脂肪打成细小的颗粒，然后均匀分布在整个肠内。所以，单凭肉眼，几乎无法分辨出它里面的脂肪。通俗说是肥肉，是多是少。为了让这些脂肪均匀分散，就要把瘦肉中的蛋白质提取出来，作为乳化剂去稳定“磨碎”的脂肪颗粒。蛋白质的提取不是件容易的事情，通常把瘦肉“打成”肉酱，在很高的盐浓度才能提取出较多的蛋白质。所以，火腿肠总是很咸，这是无法避免的问题。提取到水中的蛋白质一部分吸附到脂肪颗粒的表面，用来防止脂肪颗粒重新融合，其它的则保留在水中，在加热的时候互相交联，形成一种互相连接的的网状结构。没有溶解到水中的纤维组织以及蛋白网状结构把脂肪颗粒固定下来，就形成了火腿肠特有的质感。火腿肠的口感，就取决于这种胶状结构的强度。"
                ),
                Commodity(
                    Category.FOOD,
                    "鸡肉卷",
                    24.9,
                    R.drawable.jiroujuan,
                    "鸡肉卷，英文名为chicken rolls，是一种用烙饼卷着鸡肉的食物。\n\n鸡肉蛋白质含量较高，且易被人体吸收入利用，有增强体力，强壮身体的作用，所含对人体生长发育有重要作用的磷脂类，是中国人膳食结构中脂肪和磷脂的重要来源之一。\n\n这款佳肴是用鸡腿肉制作而成，是一道非常好吃的冷荤，既可以下酒，也可以当做小菜。宴客时这道菜肴可以提前制作，即有档次又能节省烹制时间，避免了忙乱。味道好极了。 [1] \n\n煮熟后浸泡是为了更好入味，如果急用，也可以捞出后冷藏凉透再拆纱布。如果味道不理想，可以调制一碟蘸汁，搭配食用墨西哥鸡肉卷是以荷叶饼、鸡腿、生菜、西红柿、洋葱作为主料，沙拉酱、鸡蛋、炸鸡粉作为辅料制作而成的一道美食。\n\n1. 将鸡腿肉剔骨，将鸡腿肉切成1cm宽，4cm长的条。洋葱切丝，西红柿切片，生菜洗净沥干水分备用。2. 在切好的鸡肉条中放入打散的蛋液中，均匀的裹上蛋液后蘸满炸鸡粉准备炸制。"
                ),
                Commodity(
                    Category.FOOD,
                    "脆皮炸鸡",
                    27.8,
                    R.drawable.cuipizhaji,
                    "脆皮炸鸡是广东省传统的地方名菜，属于粤菜系。脆皮炸鸡外层呈金黄色，完整紧贴不脱落且鳞片美观、香脆，丝毫不比洋快餐的炸鸡差；鸡肉汁多肉嫩，鲜香嫩滑，该技术除可用于炸鸡排，炸鸡腿、炸鸡翅中外，还适用于鱼、虾、猪肉等各种油炸食品。\n\n一．将光鸡（鸡要嫩）除去内脏杂物，揩净血水，放在准备好的白卤水内浸透（两小时）。卤水是用盐、八角、桂皮，草果、陈皮、水煮成，将鸡取出揩净，用饴糖、白醋、地栗粉调匀，遍擦鸡身，经过风干，再涂上用地栗粉、酒、醋调的糊。二．另起锅，将猪油烧到六成熟时，一面把鸡头放入炸，一面用油从鸡的肛门浇入肚内，等头呈金黄色，肚也烧热，再一面把腿放入炸，一面用油浇全身，看皮呈现金黄色，取出解刀，先把腿、翅膀切下，再从腰部进刀切成两片，最后分别切成小块，仍按整鸡形状，分两排装在盘中，中间放鸡脯肉，两边放腿肉，前面放鸡头即好。上桌时另跟椒盐。味鲜脆而嫩。\n\n快餐店和街头小贩们炸鸡是用的都是专用的炸粉炸出的鸡肉上会有一层像鱼鳞似的脆皮，我的方法是经过我多次试验后找到的一个我觉得比较好的方法，可能和洋快餐的炸鸡在外表上还有一定的距离，但是味道已经非常的好了，并且我做出的炸鸡也有一个酥香漂亮的的外壳，而且放置时间长也不会回软，真正是外酥里嫩。"
                ),
                Commodity(
                    Category.FOOD,
                    "薯条",
                    8.8,
                    R.drawable.shutiao,
                    "薯条（英文名French fries）是一种以马铃薯为原料，切成条状后油炸而成的食品，源起于比利时。是现在最常见的快餐食品之一，流行于世界各地。\n\n在第一次世界大战的时候，美国士兵在比利时吃到了这种薯条，觉得特别美味，从而变得流行起来。但他们想当然的称其为“French”，是因为当时在比利时军队中的通用语言是法语，他们就以为是“法国的薯条”了。\n\n仅对快餐店的炸薯条或超市销售的薯片加警告性标签可能起误导作用，消费者会认为只有快餐店制作的炸薯条和薯片才含丙烯酰胺，而事实上，哪怕消费者自己用土豆高温烹炸制作食品，也会含有这种物质。宝洁公司就如此声明：“不论在餐馆、家里还是食品工业，丙烯酰胺总是存在于这些食物里，而我们的产品则像过去一样非常安全。\n\n找一个炸篮，把生的薯条倒进去，炸薯条的油温要170度左右，由于薯条是冷冻的，所以要在薯条炸到1分30秒左右的时候，将炸篮提起，脱离油面，晃动5下左右，再下油锅炸，炸2分钟即可，再将油控净，将薯条倒入器皿中，高空撒盐，然后以瀑布似的方法，反复将薯条从此器皿中倒入另一器皿中3-4次，薯条即可做好，但快餐店里的油是棕榈油，而不是家中的食用油。"
                ),
                Commodity(
                    Category.FOOD,
                    "南瓜饼",
                    12.5,
                    R.drawable.nanguabing,
                    "南瓜饼是一道传统菜式，是主要以南瓜为原料做成的饼，在不同地方的制作方法有多不同。南瓜中对人体的有益成分有：多糖、氨基酸、活性蛋白、类胡罗卜素及多种微量元素等。\n\n南瓜去皮洗净，切成小块放入碗中，进微波炉高火五分钟（用蒸锅蒸熟也一样的），我的玻璃碗没有盖上盖，这样可以流失些水分，不然蒸熟的南瓜水分太多.取出蒸熟的南瓜，乘热时压成泥，加入黄油和白糖拌溶化。\n\n类胡罗卜素：南瓜饼中丰富的类胡罗卜素在机体内可转化成具有重要生理功能的维生素A，从而对上皮组织的生长分化、维持正常视觉、促进骨骼的发育具有重要生理功能。\n\n保护胃粘膜，帮助消化：南瓜饼所含果胶还可以保护胃肠道粘膜，免受粗糙食品刺激，促进溃疡面愈合，适宜于胃病患者。南瓜饼所含成分能促进胆汁分泌，加强胃肠蠕动，帮助食物消化。"
                ),
                Commodity(
                    Category.FOOD,
                    "牛排",
                    39.9,
                    R.drawable.niupai,
                    "牛排，或称牛扒，是片状的牛肉，是西餐中最常见的食物之一。牛排的烹调方法以煎和烤制为主。\n\n欧洲中世纪时，猪肉及羊肉是平民百姓的食用肉，牛肉则是王公贵族们的高级肉品，尊贵的牛肉被他们搭配上了当时也是享有尊贵身份的胡椒粉及香辛料一起烹调，并在特殊场合中供应，以彰显主人的尊贵身份。\n\n菲力牛排、肉眼牛排、西冷牛排（沙朗牛排）、T骨牛排……这些名称都是英语翻译来的，他们各有各的特点：菲力牛排（FILET）也称牛里脊，腰内肉，特点是瘦肉较多，高蛋白，低脂肪，比较适合喜欢减肥瘦身，要保持身材女子；西冷牛排（SIRLOIN），也叫沙朗牛排，是外脊肉，牛的后腰肉，含一定肥油，尤其是外延有一圈呈白色的肉筋，上口相比菲力牛排更有韧性、有嚼劲，适合年轻人和牙口好的人；T骨牛排（T—BONE），是牛背上的脊骨肉，呈T字型，两侧一边是菲力，另一边是西冷，既可以尝到菲力牛排的鲜嫩又可以感受到西冷牛排的芳香，一举两得。\n\n牛排有别于其他大部份熟食，牛排通常不会烹至全熟，因为全熟牛排最为考验厨师的手艺，可以以个人喜好调较生熟程度。生熟程度以奇数区分，"
                ),
                Commodity(
                    Category.FOOD,
                    "烤肉",
                    42.0,
                    R.drawable.kaorou,
                    "烤肉（barbecues），是一道菜品，制作原料有猪肉、牛肉、蔬菜、海鲜等。独具风味，历史悠久，有浓郁的香味和鲜美的味道，可大大提高食欲。值得一提的是，现代烤肉与刀耕火种时的烤肉并不相同。据《汉代画象全集》可知，早在两汉时期就有体系完备的烤肉烤食讲究 \n\n著名的黄家烤肉，发源于章丘古城－－绣惠镇。黄家烤肉系明末黄氏祖传，迄今300余年的历史，因其整猪烤炙，制作工艺独特，皮酥柔嫩，清香可口，早在清朝时就颇有名气，并由著名商贾孟洛川带入宫廷，受到慈禧太后的褒奖。\n\n改革开放后，黄家后人黄伍忠经过十几年磨砺创建了黄家烤肉正宗楼。出品的“伍忠黄家烤肉”以鲜香味浓，皮酥肉嫩，肥而不腻，久放长存闻名于省内外，备受社会各界欢迎。产品远销北京、天津、南京、上海及香港、澳门等地。\n\n马背民族的地道风味是烤出来的。等你进过了蒙古包，喝过了奶茶，双手接过热情好客的牧马人双手递过来的哈达。等你围着熊熊篝火，享受着草原徐徐微风送来的烤肉香，你肯定会想起“风吹草低见牛羊”。\n\n炭火调整好，先用肥肉擦拭盖板，目的是不让肉沾锅，肉摊在铁板上，听得吱吱有声，这时肉表面已经变了颜色，翻一下，再听它吱吱响，就可以吃了。烤得好的肉，外表变色，内里鲜红，这时最鲜，最嫩，最有肉的本味。胆子小的人，怕见那红红的血色，惟恐不熟，结果吃不出最好味道。"
                ),
                Commodity(
                    Category.FOOD,
                    "烧串",
                    9.9,
                    R.drawable.shaochuan,
                    "烤串泛指各种烤肉串，如羊肉串，海鲜，蔬菜，骨肉相连等。制作原料有主要有肉串、鸡精、料酒、白糖、葱片等。\n\n总之，又热闹又好吃，相当放松。吃了自己做的烤串，再也不想吃路边摊了，正宗的羊腿肉，自己烤的羊腰子、鸡翅简直比外边的好吃100倍。还有给大家算笔账，我们一个羊腿肉串60多串，单肉的成本每串都近1.4元，外边羊肉串2元，可想而知决不是什么好肉，难怪自己烤得那么好吃，真材实料，新鲜羊肉。\n\n下面开始烤羊腰子，方法和烤肉串一样，只是要多烤一会儿，另外就是羊腰子上面都是油，不断滴到木炭上，木炭就起火了，没办法垫上了馒头片烤，油滴到馒头片上，味道更好，看第二个图左边的腰子下面就放了馒头片。羊腰子，就完成了。\n\n旁边的小瓶子里边的就是番茄酱。烤了几批肉串后，火已经快灭了，我们又赶紧加了一遍木炭，这次养火的过程照了相了，由于已经有了很好的第一遍正在燃烧的木炭，所以加炭就容易多了，每一会儿新木炭就很旺盛了。\n\n下面烤鸡翅、鸡心，鸡心烤法和串一样。鸡翅要熟了的时候放上些番茄酱，这样味道很好，放好番茄酱在稍微烤一下，撒上孜然粉 [1]  和辣椒面，鸡翅、鸡心就完成啦，味道相当美！"
                ),
                Commodity(
                    Category.FOOD,
                    "烤韭菜",
                    19.9,
                    R.drawable.kaojiucai,
                    "烧烤韭菜是在南方时兴起来的一种美食，烤韭菜有强肾壮阳之功效。烤韭菜口感鲜香爽口，不仅是男人的下酒的好菜，也是女孩子们喜欢吃的一种小吃。\n\n制作：把韭菜两头都裁齐，这样好看也很方便操作。放在烤炉上烤，先刷油，等韭菜开始变软，一般2分钟韭菜就软了，开始撒料。如果烤的韭菜多的话要插花的来回反复烤，那样才能使每串韭菜都烤制均匀。\n\n韭菜独特的辛味是其所含的硫化物形成的，这些硫化物有一定的杀菌消炎作用，有助调节免疫力；硫化物还有助人体吸收维生素A及B族维生素。因此，韭菜与富含B族维生素的猪肉搭配是种营养的吃法。韭菜炒肉丝、炒鸡蛋的搭配也不错。但是需要注意的是，硫化物遇热容易挥发，因此韭菜需要急火快炒，才能保住其营养和风味。韭菜虽好，但它含膳食纤维较多，不容易消化，所以一次别吃太多，最好控制在100克以下。\n\n全韭可补肾益胃，充肺气，散瘀行滞，安五脏，行气血，止汗固涩，干呃逆。"
                ),
                Commodity(
                    Category.STORE,
                    "联想X13",
                    12999.9,
                    R.drawable.thinkpad_x13_yoga,
                    "全新十代英特尔酷睿i7-10510U/Windows 10专业版/16GB/1TBSSD/英特尔 UHD 620显示芯片/13.3英寸FHD LED背光触控显示屏 /ThinkPad 手写笔/3年部件和3年人工全国联保\n\nThinkPad（思考本）是IBM PC事业部旗下创立的便携式计算机品牌，凭借坚固和可靠的特性在业界享有很高声誉。2005年被联想（Lenovo）收购，ThinkPad商标为联想所有。\n\n“ThinkPad”这个名称的灵感来自IBM的便笺簿。每一位IBM的雇员或到IBM训练中心受训的人，都会拿到一本便笺簿（“便笺簿”英文为“pad”），上面印着企业的座右铭“THINK”。在一次讨论便携式电脑产品名称的会议上，一名与会者随手将一本这样的便笺簿甩到半空然后落在了会议桌上，另一名与会者受此启发提出可以用“ThinkPad”这个名称。起初IBM高层一度反对使用这个名称，因为以前IBM一直使用数字为标识产品型号。但是“ThinkPad”这个名称受到广大雇员和客户的极大欢迎和喜爱，最终IBM高层妥协同意使用“ThinkPad”作为产品名称。\n\n诞生于1986年名为IBM PC convertible 5140虽然是IBM第一台笔记本电脑，但5140却只拥有9.5Kg的惊人重量，它采用了低功耗8080处理器、拥有4.77MHz主频，256kb内存（可扩充至512k），两个3.5英寸软驱，可附加LCD显示器。虽然现在看来，上面的配置根本无法想象，但在当时，5140的确称得上是一款采用最强配置、性能强劲的便携电脑。"
                ),
                Commodity(
                    Category.STORE,
                    "S20+",
                    6999.0,
                    R.drawable.s20_ultra,
                    "1.为保障消费者合理购买需求及公平交易机会，避免因非生活消费目的的购买或囤积商品、抬价转售等行为发生，商城有权对异常订单*不发货。\n\n*异常订单：包括但不限于相同用户ID批量下单、同一用户（指不同用户ID，存在相同/临近/虚构地址、或相同联系号码、收件人、支付宝付款人等情形的）批量下单、以及其他非消费目的的交易订单。2.Galaxy S20系列手机，出厂自带手机贴膜，请确认需求后再激活使用，如手机激活或者前屏、内屏、后屏贴膜撕掉、划伤或者揭起重贴导致异物和气泡现象，都无法进行受理7天无理由退换货，为保障您的权益，请在下单前阅读以上三星手机 售后服务说明；\n\n目前各大手机厂商除了在手机的屏幕材质、手机的分辨率等各方面进行升级之外，现在又开始对手机的屏幕刷新率进行了升级，目前顶级旗舰手机的屏幕刷新率达到了120赫兹，而主流的手机屏幕刷新也不过是在60赫兹的水平。那么是否屏幕刷新率越高，那么就越耗电呢？外媒准备了两部三星S20Ultra，将屏幕分别设置成60赫兹刷新和120赫兹刷新，然后同时满电量进行测试，让我们一起来看下测试结果。"
                ),
                Commodity(
                    Category.STORE,
                    "一加8Pro",
                    5399.0,
                    R.drawable.yijia8_pro,
                    "随着时间的流逝，距离一年一度的年终大促也仅剩不到2天的时间，相信很多朋友们都想趁着此次机会更换一台全新的设备。而作为当下备受欢迎的一加8 Pro，自开售以来口碑便是一片好评，因此也被诸多网友们称为“618年终大促的最佳之选”。那么，对于还没有入手一加8 Pro的用户们而言，为什么一加8 Pro能成为消费者购买机型的首选呢？今天我们就来分析一下。\n\n先不说一加主打年轻化的品牌路线与精益求精的企业精神，单论屏幕而言，一加8 Pro就是当下市面上最顶级的一款机型机型。不仅有着 120Hz 瞳孔屏，而且，还内置了高端旗舰电视才有的MEMC 插帧技术，可以让画面变的更加流畅，清晰。\n\n另外，一加还与腾讯、网易等全球顶尖的游戏公司紧密合作，将推出更多热门手游高帧模式，通过滑动操作、影音娱乐与手游三大核心应用场景的优化，建立高帧内容生态，引领行业进入高帧 2.0 时代。这对于大部分喜欢玩游戏的用户们而言，还是非常友好的\n\n同时，为了给用户们带来更加惊艳的用机体验，一加8 Pro还采用了第五代AG磨砂工艺，不仅能带来更加惊艳的外观颜值之外，还能带来更加流畅舒适的手持握感。对于那些追求时尚个性的用户们而言，一加8 Pro的外观颜值绝对能满足他们的需求。"
                ),
                Commodity(
                    Category.STORE,
                    "Aero 15",
                    24999.0,
                    R.drawable.aero15,
                    "随着移动办公概念的兴起，办公环境已经不再局限于公司的办公室，你也可以选择在舒服的家中、环境优雅的咖啡厅里办公，因此越来越多的用户选择用户轻薄便携的笔记本电脑来完成工作。不过对于设计或视频剪辑这类高负荷工作而言，对笔记本电脑的配置和性能都有非常高的要求，而技嘉NewAero 15 KB就是为此而生。值得一提的是，这款笔记本还开启了预约促销活动，100元定金即可抵2000元购机款，可谓十分超值！接下来就跟随小编一起了解一下这款优秀的笔记本电脑吧。\n\n前不久Intel发布了全新的第十代酷睿标压处理器，为追求更强处理性能的用户提供了更好的选择。技嘉NewAero 15 KB便搭载了最新的十代i7-10750H处理器，其采用了六核心、十二线程设计，可以轻松运行PS、PR这种需要大量数据运算的软件；主频2.6GHz，最高睿频5.0GHz的设计，既能够在低负荷状态下带来更好的功耗表现，也可以在游戏等追求高频率的应用下获得更出色的使用体验。\n\n显卡方面，技嘉NewAero 15 KB采用了全新一代图灵架构的NVIDIA GeForce RTX 2060独立显卡，在图形处理方面拥有更加高效的表现，可以有效缩短视频编码、3D建模和图像处理所耗费的时间。与此同时，它支持的光线追踪、AI技术，以及NVIDIA Studio驱动程序，也能够在Maya 2019、3Ds Max 2020等专业软件中提供更好的性能和效率表现。再加上该机通过Adobe系列软件的全兼容测试，确保用户在挥洒创意时能够稳定且高效运行，真正帮助用户提升生产力。"
                ),
                Commodity(
                    Category.STORE,
                    "RAX80",
                    2999.0,
                    R.drawable.rax80,
                    " 今年9月6号，用了一年半的网件R6400突然挂了，具体的症状是5G WIFI信号要离的很近，近到1米内才能搜索到信号，上网查了一下这款是有2年保修的，于是打网件的400-830-3815技术支持电话，反馈情况之后，技术人员告诉我，应该是5G功放模块坏了造成的，表示可以保修。便就近寄到了上海的售后中心进行售后，于9月8号就收到了网件售后中心寄来的R6800,开始还以为寄错了，后来才得知R6400售后换货，都是换的全新的R6800。\n\n  第一台网件的路由器是WNDR4300，2014年6月在网件天猫旗舰店购买的，现在应该已经停产了。这是一台让对网件建立了非常之好感的路由器，性能之稳定让我惊叹，以致到现在我都觉得花了345块钱的【巨资】是非常划算的，毕竟在我买这个路由器之前，我心里一直觉得路由器就应该是50，100块钱这样的。但50-100块钱的路由器三番五次伤我心之后，咬牙上了这个。现在这台路由器还在父母家服役。\n\n第三台便是售后换回来的R6800,没有调查，就没有发言权！经过2个月的使用之后，我觉得这是一台不错的路由器.不错在哪些地方，听我慢慢道来。"
                ),
                Commodity(
                    Category.STORE,
                    "索尼A9G",
                    24999.0,
                    R.drawable.sony_tv,
                    "说到电视，大家肯定会想起日货，当年的夏普、索尼、松下、东芝都有很多好产品，不过现在日系电视都没了当年的威风，还剩索尼扛着日系电视的招牌。由于昔日的好口碑，所以大部分家庭对索尼电视都抱有好感，在缺乏对比的情况下，索尼电视有足够的吸引力促使消费者购买。不过精明的消费者肯定想花钱花得明明白白，今天我们就来解析一下，索尼4K电视画质到底好在哪？值不值得无脑购物索尼4K电视。\n\n说到画质，大家第一反应就是面板要好，索尼电视肯定面板比别人好，画质才那么好，这是很多消费者的观念。事实上，索尼没有自己的面板，也是采购其他厂商的面板，所以大家对面板这一块要放宽心，现在出货最多的就是国产屏，所以单凭面板断画质是不可取的。\n\n电视生产商会根据自身产品的定位向供应商订购合格的产品，所以根据不同的产品系列，你可能用到韩国屏，或者是台湾屏，甚至是国产屏也是很有可能的，质量和效果都是根据你的产品价格决定，谨记一分钱一分货，总不能2K买的机器，跟2W的机器扳手腕，这是不科学的。\n\n当前面板有VA、IPS、OLED屏几种，一般高端用OLED，中端IPS，低端或超大屏用VA，低端并不代表画质差，面板如果有强大的算法驱动支撑，那么效果肯定不会差的，当然好算法，再加上好面板，自然是旗舰电视的必备之选。"
                ),
                Commodity(
                    Category.STORE,
                    "罗技G402",
                    299.0,
                    R.drawable.luoji_g402,
                    "对于现在的很多人来说，他们每天大部分的时间就是呆在写字楼中，对着电脑，敲着键盘，做着各种不同的工作。用电脑进行工作，不仅可以解决很多工作里遇到的麻烦，还能提高工作效率，追赶上紧张的工作节奏。不过即使工作氛围很严肃，还是有着许多人在追求自由。为了能够进一步提升自己的工作能力，许多人都会用一些简便的方式去操作电脑，让自己能够用更短的时间做更多的事情。\n\n要熟练地操作电脑，不仅要依靠自身的技术和实力，更要拥有好的辅助设备。在电脑的众多设备里，能够影响操作的就是鼠标了。鼠标对于办公很重要，它的灵敏度和响应速度决定工作的效率，因此许多用电脑办公的人会去选择一款优质的鼠标，让自己可以更自由地去操作，更快地完成工作任务\n\n选择好的鼠标，当然得选择罗技。罗技鼠标有着出色的响应速度，能够精准识别每一个操作，不仅使办公更加流畅，也会带来轻松的体验感。那么接下来就为大家测评一款罗技MX Master 3鼠标，看看它在办公方面有哪些能力\n\n罗技MX Master 3鼠标上搭载了全新的MAGSPEED电磁滚轮，有着非常精准的定位功能，它可以迅速滚动，准确的定位目标，一秒行千里的滚动速度，能够让画面更加流畅，缩短寻找目标的时间。罗技MX Master 3鼠标的滚轮拥有钢制结构，能够带来优秀的触感，分量也很适中，让滚轮在使用的过程中能够保持安静，不会打扰到工作"
                ),
                Commodity(
                    Category.STORE,
                    "EX575",
                    8899.0,
                    R.drawable.sony_projector,
                    "投影仪，又称投影机，是一种可以将图像或视频投射到幕布上的设备，可以通过不同的接口同计算机、VCD、DVD、BD、游戏机、DV等相连接播放相应的视频信号。\n\n投影仪广泛应用于家庭、办公室、学校和娱乐场所，根据工作方式不同，有CRT，LCD，DLP等不同类型。\n\n家庭影院型：其特点是亮度都在2000流明左右(随着投影的发展这个数字在不断的增大,对比度较高)，投影的画面宽高比多为16：9，各种视频端口齐全，适合播放电影和高清晰电视，适于家庭用户使用。\n\n测量投影仪：这类投影仪不同于以上几类投影仪，早期称轮廓投影仪，随着光栅尺的普及，投影仪都安装上高精度的光栅尺，人们便又叫测量投影仪（或投影仪，如国内较著名的测量投影仪有高诚公司生产的CPJ-3015），为与传统的投影仪区别开，这类投影仪便称为测量投影仪。其作用主要是将产品零件通过光的透射形成放大的投影仪，然后用标准胶片或光栅尺等确定产品的尺寸。由于工业化的发展，这种测量投影仪已经成为制造业最常用的检测仪器之一。按期投影的方式分为立式投影仪和卧式投影仪。按其比对的标准不同又分为轮廓投影仪和数字式投影仪。 [1]\n\n市售的主流投影机所采用的技术方案基本分为数字光处理(DLP)技术与3LCD技术。"
                )
            )
        )
    }
}