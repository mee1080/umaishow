package io.github.mee1080.umaishow.data

object RelationInfo {

    fun getShortString(set: Set<Int>): String {
        return shortNames.joinToString("") {
            if (set.contains(it.first)) it.second else "　"
        }
    }

    fun getLongString(set: Set<Int>): List<String> {
        return names.filter { set.contains(it.first) }.map { it.second }
    }

    val shortNames = buildList {
        add(3101 to "芝")
        add(3102 to "ダ")
        add(3001 to "短")
        add(3002 to "マ")
        add(3003 to "中")
        add(3004 to "長")
        add(2901 to "逃")
        add(2902 to "先")
        add(2903 to "差")
        add(2904 to "追")
    }

    val filters = buildList {
        add(101 to "中等部1年")
        add(102 to "中等部2年")
        add(103 to "中等部3年")
        add(104 to "高等部1年")
        add(105 to "高等部2年")
        add(106 to "高等部3年")

        add(201 to "美浦寮")
        add(202 to "栗東寮")



























































































        add(401 to "98世代")



















        add(501 to "生徒会")

        add(503 to "メジロ")
        add(504 to "お嬢様？")
        add(505 to "寮長")
        add(506 to "永世3強＋タマ")
        add(507 to "BNW")



        add(511 to "ヴィクトリー倶楽部")
        add(512 to "力士？")
        add(513 to "カノープス")
        add(514 to "爆逃げコンビ")



        add(518 to "逃げシス")
        add(519 to "魔法少女☆スイーピー5")
        add(520 to "ダート組")
        add(521 to "舞台組")

        add(523 to "チームシリウス")
        add(524 to "チームリギル")
        add(525 to "チームスピカ")
        add(526 to "大逃げ組")

























        add(2001 to "父：サンデーサイレンス")
        add(2002 to "父：トニービン")
        add(2003 to "父：サクラユタカオー")
        add(2004 to "父：メジロライアン")



        add(2008 to "父：トウショウボーイ")
        add(2009 to "父：ブライアンズタイム（ウオッカは父父、設定ミス？）")
        add(2010 to "父：ゴールドアリュール")

        add(2101 to "父父：サンデーサイレンス")
        add(2102 to "母父：マルゼンスキー？（ライスシャワー、メジロブライト設定漏れ？）")
        add(2103 to "父父：Robert")
        add(2104 to "母父：Blushing Groom")
        add(2105 to "父父：ノーザンダンサー")
        add(2106 to "母父：ノーザンテースト（アルダンは父父、対象外）")
        add(2107 to "母父：ロイヤルスキー")
        add(2108 to "母父：ネヴァービート")

        add(2110 to "母父：サンシー")




        add(2201 to "父と子")
        add(2202 to "父と子")
        add(2203 to "母父と子")
        add(2204 to "父と子")
        add(2205 to "母父と子")




        add(2301 to "母父と子")
        add(2302 to "母父と子")
        add(2303 to "母父と子")
        add(2401 to "1976年デビュー")
        add(2402 to "1983年デビュー")
        add(2403 to "1987年デビュー")
        add(2404 to "1990～1991年デビュー")
        add(2405 to "1992～1995年デビュー")
        add(2406 to "1996～1997年デビュー")
        add(2407 to "1998～2000年デビュー")
        add(2408 to "2001～2003年デビュー")
        add(2409 to "2006年デビュー")
        add(2410 to "2008～2011年デビュー")
        add(2411 to "2012年デビュー")
        add(2501 to "フェブラリーS")
        add(2502 to "高松宮記念（高松宮杯は含まない）")
        add(2503 to "大阪杯（GII産経大阪杯含む）")
        add(2504 to "桜花賞")
        add(2505 to "皐月賞")
        add(2506 to "天皇賞（春）")
        add(2507 to "NHKマイルC")
        add(2508 to "ヴィクトリアマイル")
        add(2509 to "オークス")
        add(2510 to "ダービー")
        add(2511 to "安田記念")
        add(2512 to "宝塚記念")
        add(2513 to "スプリンターズS")
        add(2514 to "秋華賞")
        add(2515 to "菊花賞")
        add(2516 to "天皇賞（秋）")
        add(2517 to "エリザベス女王杯")
        add(2518 to "マイルCS")
        add(2519 to "ジャパンC")
        add(2520 to "チャンピオンズC")
        add(2521 to "阪神JF")
        add(2522 to "朝日杯FS")
        add(2523 to "有馬記念")
        add(2524 to "ホープフルステークス（ラジオたんぱ杯3歳S含む）")
        add(2525 to "帝王賞")



        add(2529 to "JBCクラシック")
        add(2530 to "東京大賞典")
        add(2531 to "川崎記念")
        add(2532 to "マイルCS南部杯")
        add(2533 to "かしわ記念")
        add(2534 to "香港カップ？")
        add(2601 to "牡馬")
        add(2602 to "牝馬")


        add(2701 to "3/27生まれ")
        add(2702 to "3/13生まれ")
        add(2703 to "3/10生まれ")
        add(2704 to "3/5生まれ")
        add(2705 to "4/4生まれ")
        add(2706 to "4/16生まれ")
        add(2707 to "2/27生まれ")
        add(2708 to "3/14生まれ")

        add(2710 to "3/21生まれ")
        add(2711 to "3/24生まれ")
        add(2712 to "3/26生まれ")
        add(2713 to "3/31生まれ")
        add(2714 to "4/6生まれ")

        add(2716 to "4/10生まれ")
        add(2717 to "4/11生まれ")

        add(2719 to "4/13生まれ")
        add(2720 to "4/14生まれ")
        add(2721 to "4/15生まれ")
        add(2722 to "4/19生まれ")
        add(2723 to "4/26生まれ")
        add(2724 to "5/1生まれ")
        add(2725 to "5/2生まれ")
        add(2726 to "5/7生まれ")
        add(2727 to "5/27生まれ")
        add(2801 to "1984年誕生")
        add(2802 to "1985年誕生")
        add(2803 to "1987年誕生")
        add(2804 to "1988年誕生")
        add(2805 to "1989年誕生")
        add(2806 to "1990年誕生")
        add(2807 to "1991年誕生")
        add(2808 to "1992年誕生")
        add(2809 to "1993年誕生")
        add(2810 to "1994年誕生")
        add(2811 to "1995年誕生")
        add(2812 to "1996年誕生")
        add(2813 to "1997年誕生")
        add(2814 to "1998年誕生")
        add(2815 to "2004年誕生")
        add(2816 to "2006年誕生")
        add(2817 to "2007年誕生")




        add(2822 to "1999年誕生")
        add(2823 to "2000年誕生")
        add(2824 to "2013年誕生")
        add(2825 to "1980年誕生")
        add(2826 to "2005年誕生")
        add(2827 to "2009年誕生")
        add(2828 to "2012年誕生")
        add(2901 to "逃げ")
        add(2902 to "先行")
        add(2903 to "差し")
        add(2904 to "追込")
        add(3001 to "短距離")
        add(3002 to "マイル")
        add(3003 to "中距離")
        add(3004 to "長距離")
        add(3101 to "芝")
        add(3102 to "ダート")
        add(3201 to "1月生まれ")
        add(3202 to "2月生まれ")
        add(3203 to "3月生まれ")
        add(3204 to "4月生まれ")
        add(3205 to "5月生まれ")
        add(3206 to "6月生まれ")
        add(3301 to "GI勝利なし")
        add(3401 to "不明3401")
        add(3501 to "種牡馬＋何らかの条件？")
        add(3502 to "繁殖牝馬？")
        add(3503 to "不明3503")
        add(3504 to "不明3504")
        add(3505 to "地方出走？")
        add(3506 to "海外出走？")
        add(3507 to "たぶん出走レース関連だけど不明")
        add(3508 to "短距離出走？")
        add(3509 to "マイル出走？")
    }

    val names = buildList {
        add(101 to "中等部1年")
        add(102 to "中等部2年")
        add(103 to "中等部3年")
        add(104 to "高等部1年")
        add(105 to "高等部2年")
        add(106 to "高等部3年")

        add(201 to "美浦寮")
        add(202 to "栗東寮")
        add(203 to "一人暮らし1")
        add(204 to "一人暮らし2")
        add(205 to "一人暮らし3")
        add(301 to "相部屋1")
        add(302 to "相部屋2")
        add(303 to "相部屋3")
        add(304 to "相部屋4")
        add(305 to "相部屋5")
        add(306 to "相部屋6")
        add(307 to "相部屋7")
        add(308 to "相部屋8")
        add(309 to "相部屋9")
        add(310 to "相部屋10")
        add(311 to "相部屋11")
        add(312 to "相部屋12")
        add(313 to "相部屋13")
        add(314 to "相部屋14")
        add(315 to "相部屋15")
        add(316 to "相部屋16")
        add(317 to "相部屋17")
        add(318 to "相部屋18")
        add(319 to "相部屋19")
        add(320 to "相部屋20")
        add(321 to "相部屋21")
        add(322 to "相部屋22")
        add(323 to "相部屋23")
        add(324 to "相部屋24")
        add(325 to "相部屋25")
        add(326 to "相部屋26")
        add(327 to "相部屋27")
        add(328 to "相部屋28")
        add(329 to "相部屋29")
        add(330 to "相部屋30")
        add(331 to "相部屋31")
        add(332 to "相部屋32")
        add(333 to "相部屋33")
        add(334 to "相部屋34")
        add(335 to "相部屋35")
        add(336 to "相部屋36")
        add(337 to "相部屋37")
        add(338 to "相部屋38")
        add(339 to "相部屋39")
        add(340 to "相部屋40")
        add(341 to "相部屋41")
        add(342 to "相部屋42")
        add(343 to "相部屋43")
        add(344 to "相部屋44")
        add(345 to "相部屋45")
        add(346 to "相部屋46")
        add(347 to "相部屋47")
        add(348 to "相部屋48")
        add(349 to "相部屋49")
        add(350 to "相部屋50")
        add(351 to "相部屋51")
        add(352 to "相部屋52")
        add(353 to "相部屋53")
        add(354 to "相部屋54")
        add(355 to "相部屋55")
        add(356 to "相部屋56")
        add(357 to "相部屋57")
        add(358 to "相部屋58")
        add(359 to "相部屋59")
        add(360 to "相部屋60")
        add(361 to "相部屋61")
        add(362 to "相部屋62")
        add(363 to "相部屋63")
        add(364 to "相部屋64")
        add(365 to "相部屋65")
        add(366 to "相部屋66")
        add(367 to "相部屋67")
        add(368 to "相部屋68")
        add(369 to "相部屋69")
        add(370 to "相部屋70")
        add(371 to "相部屋71")
        add(372 to "相部屋72")
        add(373 to "相部屋73")
        add(374 to "相部屋74")
        add(375 to "相部屋75")
        add(376 to "相部屋76")
        add(377 to "相部屋77")
        add(378 to "相部屋78")
        add(379 to "相部屋79")
        add(380 to "相部屋80")
        add(381 to "相部屋81")
        add(382 to "相部屋82")
        add(383 to "相部屋83")
        add(384 to "相部屋84")
        add(385 to "相部屋85")
        add(386 to "相部屋86")
        add(387 to "相部屋87")
        add(388 to "相部屋88")
        add(401 to "98世代")












        add(414 to "99世代？（アヤベoutウララin）")


        add(417 to "勇者＆英雄？")



        add(501 to "生徒会")
        add(502 to "98世代？（キング除く）")
        add(503 to "メジロ")
        add(504 to "お嬢様？")
        add(505 to "寮長")
        add(506 to "永世3強＋タマ")
        add(507 to "BNW")
        add(508 to "うっららー")
        add(509 to "うっららー")
        add(510 to "うっららー")
        add(511 to "ヴィクトリー倶楽部")
        add(512 to "力士？")
        add(513 to "カノープス")
        add(514 to "爆逃げコンビ")
        add(515 to "キタサト")
        add(516 to "マックダイヤ")
        add(517 to "テイオーキタサン")
        add(518 to "逃げシス")
        add(519 to "魔法少女☆スイーピー5")
        add(520 to "ダート組")
        add(521 to "舞台組")
        add(522 to "サトノ？")
        add(523 to "チームシリウス")
        add(524 to "チームリギル")
        add(525 to "チームスピカ")
        add(526 to "大逃げ組")
        add(527 to "うっららー")
        add(528 to "うっららー")
        add(529 to "うっららー")
        add(530 to "うっららー")
        add(531 to "うっららー")
        add(532 to "うっららー")
        add(533 to "うっららー")
        add(534 to "うっららー")
        add(535 to "うっららー")
        add(536 to "うっららー")
        add(537 to "うっららー")
        add(538 to "うっららー")
        add(539 to "うっららー")
        add(540 to "うっららー")
        add(541 to "うっららー")
        add(542 to "うっららー")
        add(543 to "うっららー")
        add(544 to "うっららー")
        add(545 to "うっららー")
        add(546 to "うっららー")
        add(547 to "うっららー")
        add(548 to "うっららー")
        add(549 to "うっららー")
        add(550 to "うっららー")
        add(551 to "うっららー")
        add(2001 to "父：サンデーサイレンス")
        add(2002 to "父：トニービン")
        add(2003 to "父：サクラユタカオー")
        add(2004 to "父：メジロライアン")


        add(2007 to "父：シンボリルドルフ？（＋ツヨシ）")
        add(2008 to "父：トウショウボーイ")
        add(2009 to "父：ブライアンズタイム（ウオッカは父父、設定ミス？）")
        add(2010 to "父：ゴールドアリュール")
        add(2011 to "父：サッカーボーイ？（＋トプロ）")
        add(2101 to "父父：サンデーサイレンス")
        add(2102 to "母父：マルゼンスキー？（ライスシャワー、メジロブライト設定漏れ？）")
        add(2103 to "父父：Robert")
        add(2104 to "母父：Blushing Groom")
        add(2105 to "父父：ノーザンダンサー")
        add(2106 to "母父：ノーザンテースト（アルダンは父父、対象外）")
        add(2107 to "母父：ロイヤルスキー")
        add(2108 to "母父：ネヴァービート")
        add(2109 to "父父：ラストタイクーン？（＋サトノクラウン）")
        add(2110 to "母父：サンシー")
        add(2111 to "母父：Affirmed？（＋ナリタトップロード）")



        add(2201 to "父と子")
        add(2202 to "父と子")
        add(2203 to "母父と子")
        add(2204 to "父と子")
        add(2205 to "母父と子")
        add(2206 to "（＋ツヨシで父と子？）")
        add(2207 to "（＋デアリングタクトで父父と子？）")
        add(2208 to "（＋ジャンポケで父と子？）")
        add(2209 to "（＋ヴィクトワールピサで父と子？）")
        add(2301 to "母父と子")
        add(2302 to "母父と子")
        add(2303 to "母父と子")
        add(2401 to "1976年デビュー")
        add(2402 to "1983年デビュー")
        add(2403 to "1987年デビュー")
        add(2404 to "1990～1991年デビュー")
        add(2405 to "1992～1995年デビュー")
        add(2406 to "1996～1997年デビュー")
        add(2407 to "1998～2000年デビュー")
        add(2408 to "2001～2003年デビュー")
        add(2409 to "2006年デビュー")
        add(2410 to "2008～2011年デビュー")
        add(2411 to "2012年デビュー")
        add(2501 to "フェブラリーS")
        add(2502 to "高松宮記念（高松宮杯は含まない）")
        add(2503 to "大阪杯（GII産経大阪杯含む）")
        add(2504 to "桜花賞")
        add(2505 to "皐月賞")
        add(2506 to "天皇賞（春）")
        add(2507 to "NHKマイルC")
        add(2508 to "ヴィクトリアマイル")
        add(2509 to "オークス")
        add(2510 to "ダービー")
        add(2511 to "安田記念")
        add(2512 to "宝塚記念")
        add(2513 to "スプリンターズS")
        add(2514 to "秋華賞")
        add(2515 to "菊花賞")
        add(2516 to "天皇賞（秋）")
        add(2517 to "エリザベス女王杯")
        add(2518 to "マイルCS")
        add(2519 to "ジャパンC")
        add(2520 to "チャンピオンズC")
        add(2521 to "阪神JF")
        add(2522 to "朝日杯FS")
        add(2523 to "有馬記念")
        add(2524 to "ホープフルステークス（ラジオたんぱ杯3歳S含む）")
        add(2525 to "帝王賞")



        add(2529 to "JBCクラシック")
        add(2530 to "東京大賞典")
        add(2531 to "川崎記念")
        add(2532 to "マイルCS南部杯")
        add(2533 to "かしわ記念")
        add(2534 to "香港カップ？")
        add(2601 to "牡馬")
        add(2602 to "牝馬")


        add(2701 to "3/27生まれ")
        add(2702 to "3/13生まれ")
        add(2703 to "3/10生まれ")
        add(2704 to "3/5生まれ")
        add(2705 to "4/4生まれ")
        add(2706 to "4/16生まれ")
        add(2707 to "2/27生まれ")
        add(2708 to "3/14生まれ")

        add(2710 to "3/21生まれ")
        add(2711 to "3/24生まれ")
        add(2712 to "3/26生まれ")
        add(2713 to "3/31生まれ")
        add(2714 to "4/6生まれ")

        add(2716 to "4/10生まれ")
        add(2717 to "4/11生まれ")

        add(2719 to "4/13生まれ")
        add(2720 to "4/14生まれ")
        add(2721 to "4/15生まれ")
        add(2722 to "4/19生まれ")
        add(2723 to "4/26生まれ")
        add(2724 to "5/1生まれ")
        add(2725 to "5/2生まれ")
        add(2726 to "5/7生まれ")
        add(2727 to "5/27生まれ")
        add(2801 to "1984年誕生")
        add(2802 to "1985年誕生")
        add(2803 to "1987年誕生")
        add(2804 to "1988年誕生")
        add(2805 to "1989年誕生")
        add(2806 to "1990年誕生")
        add(2807 to "1991年誕生")
        add(2808 to "1992年誕生")
        add(2809 to "1993年誕生")
        add(2810 to "1994年誕生")
        add(2811 to "1995年誕生")
        add(2812 to "1996年誕生")
        add(2813 to "1997年誕生")
        add(2814 to "1998年誕生")
        add(2815 to "2004年誕生")
        add(2816 to "2006年誕生")
        add(2817 to "2007年誕生")




        add(2822 to "1999年誕生")
        add(2823 to "2000年誕生")
        add(2824 to "2013年誕生")
        add(2825 to "1980年誕生")
        add(2826 to "2005年誕生")
        add(2827 to "2009年誕生")
        add(2828 to "2012年誕生")
        add(2901 to "逃げ")
        add(2902 to "先行")
        add(2903 to "差し")
        add(2904 to "追込")
        add(3001 to "短距離")
        add(3002 to "マイル")
        add(3003 to "中距離")
        add(3004 to "長距離")
        add(3101 to "芝")
        add(3102 to "ダート")
        add(3201 to "1月生まれ")
        add(3202 to "2月生まれ")
        add(3203 to "3月生まれ")
        add(3204 to "4月生まれ")
        add(3205 to "5月生まれ")
        add(3206 to "6月生まれ")
        add(3301 to "GI勝利なし")
        add(3401 to "不明3401")
        add(3501 to "種牡馬＋何らかの条件？")
        add(3502 to "繁殖牝馬？")
        add(3503 to "不明3503")
        add(3504 to "不明3504")
        add(3505 to "地方出走？")
        add(3506 to "海外出走？")
        add(3507 to "たぶん出走レース関連だけど不明")
        add(3508 to "短距離出走？")
        add(3509 to "マイル出走？")
    }
}