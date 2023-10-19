package io.github.mee1080.umaishow.data

object Source {

    val chara: List<Pair<String, Set<Int>>> = listOf(
"アイネスフウジン" to setOf(105,201,311,2105,2601,7020,2803,2901,3002,3003,3101,2510,2522,3204,8360,2404,2603,408,518,2716,3501,3507),
"アグネスタキオン" to setOf(104,202,314,2001,2107,2601,2814,2903,3003,3101,2505,3204,8219,8220,8221,8222,8223,8224,8225,8226,8227,8228,8229,8230,8231,8232,8233,8234,2407,2604,8450,8486,8518,8543,8647,519,8682,8706,8880,9158,410,2719,2524,3507),
"アグネスデジタル" to setOf(102,202,314,2601,2813,2902,3002,3003,3101,3102,2516,2511,2518,2501,3205,8144,8145,8146,8147,8148,8149,8150,8151,8456,8524,8600,8623,8752,8907,8939,8971,9098,9190,2532,2604,417,527,2534,3401,3504,3505,3506,3507,3509,2407),
"アストンマーチャン" to setOf(2901,3001,3203,102,2604,202,2602,2704,2815,3101,2513,8659,8719,8739,8797,8838,8839,8840,8841,8842,8843,8845,8846,8847,8848,8849,8850,8851,8852,8853,8854,8855,8856,8858,8859,8861,8862,8863,2409,403,3508,9236,9288),
"アドマイヤベガ" to setOf(105,202,315,2601,2812,2904,3003,3101,2510,8235,8236,8237,8238,8239,8240,8241,8242,8243,8244,8245,8246,8247,8248,8249,8250,8451,8487,8519,8544,8648,8683,8707,8881,9159,2603,3203,404,538,2524,3501,3507,2407),
"イナリワン" to setOf(106,201,506,2601,2801,2904,3003,3004,3101,3102,2523,2512,2506,331,2530,2403,2604,3205,405,2726,3401,3503,3504,3505),
"ウイニングチケット" to setOf(105,202,316,404,507,2002,2102,2302,2601,7018,7021,2806,2903,3003,3101,2510,3203,8038,8048,8075,8080,8103,8139,8194,8293,8325,8332,8353,8404,2405,2603,8430,8495,8552,8590,8613,8656,8716,8736,8794,8891,8923,8955,9082,9132,9174,523,2710,3501,3504,9233,9285),
"ウオッカ" to setOf(102,202,303,403,2602,7012,2705,2815,2903,3002,3003,3101,2510,2516,2521,2511,2519,2508,3204,2409,2604,2009,525,3401,3502,3504,3506,3507,3509,2210),
"エアグルーヴ" to setOf(105,202,307,501,2002,2106,2602,7001,2809,2902,3003,3101,2509,2516,3204,8035,8045,8072,8077,8100,8136,8190,8289,8322,8329,8350,8400,2406,2604,8427,8492,8549,8587,8610,8653,8713,8733,8791,8888,8920,8952,9079,9129,9171,404,524,2714,2503,3502,3503,3504,9230,9282),
"エアシャカール" to setOf(104,202,317,2001,2601,2813,2904,3003,3101,2505,2515,3202,8251,8252,8253,8254,8255,8256,8257,8258,8259,8260,8261,8262,8263,8264,8265,8266,8452,8488,8520,8545,8649,2603,2407,8684,8708,8882,9160,410,529,3501,3503,3504,3506),
"エイシンフラッシュ" to setOf(105,202,318,2601,2701,2817,2903,3003,3101,2510,2516,3203,8267,8268,8269,8270,8271,8272,8273,8274,8458,8526,8602,8625,8754,8909,8941,8973,9100,9192,2603,407,3401,3501,3503,3504,3506,2410),
"エルコンドルパサー" to setOf(103,201,305,401,502,2601,7000,7004,2811,2902,3002,3003,3101,2519,2507,3203,8108,8109,8110,8111,8112,8113,8114,8115,2406,2604,8455,8523,8599,8622,8751,8906,8938,8970,9097,9189,524,3506,3509),
"オグリキャップ" to setOf(106,202,302,506,2601,7009,7010,7011,2701,2802,2903,3002,3003,3101,2523,2511,2518,3203,8068,8069,8070,8071,8116,8178,8275,8285,8310,8413,8415,8417,2403,2603,8436,8472,8503,8529,8633,8865,405,523,545,3504,3505,3509),
"カツラギエース" to setOf(2901,329,3101,202,406,548,2825,2512,2519,2503,3501,3503,3504,2402,2603,106,2601,3003,3204,9230,9231,9232,9233,9234,9235,9236,9237,9238,9239,9240,9241,9242,9243,9244,9245,9246,9247,9248,9249,9250,9251,9252,9253,9254,9255,9256),
"カレンチャン" to setOf(102,202,315,2602,2817,2902,3001,3101,2502,2513,8008,8024,8059,8089,8125,8155,8169,8195,8210,8226,8242,8258,8275,8276,8294,8341,8361,8387,8405,8560,8805,9036,9061,2603,3203,416,543,2713,3506,3508,2410,9244,9264),
"カワカミプリンセス" to setOf(103,202,319,2602,2903,3002,3003,3101,2509,2514,8277,8278,8279,8280,8281,8282,8283,8284,8362,8605,8628,8689,8726,8759,8914,8946,8978,9105,9165,9197,2604,413,546,3502,3206,2409),
"キタサンブラック" to setOf(8466,8502,8581,8587,8588,8589,8590,8591,8592,8593,8594,8596,8597,8598,8599,8600,8601,8602,8603,8604,8605,8606,8607,2901,3003,3004,3101,2523,2506,2516,2515,2519,3203,2604,101,202,332,515,517,2203,2601,7029,2703,8667,8770,8824,8843,8989,9007,9116,9143,9208,420,519,2828,2503,3501,3503,3504),
"キングヘイロー" to setOf(103,202,322,401,504,2601,7007,7023,7024,2811,2903,3001,3101,2502,3204,8371,8419,8420,8421,8422,8423,8424,8425,8426,2406,2604,8607,8630,8691,8728,8761,8916,8948,8980,9107,9167,9199,541,3501,3504,3508,3509),
"グラスワンダー" to setOf(103,201,305,401,502,2103,2601,7003,7013,7023,2811,2903,3002,3003,3101,2523,2512,2522,3202,2406,2604,524,536,3507,3509),
"ケイエスミラクル" to setOf(3001,3203,339,2804,105,202,2601,3101,8757,8912,8944,8976,8984,8985,8986,8987,8988,8989,8994,8995,8996,8997,8998,8999,9000,9001,2404,2902,408,521,2709,3301,3508,2604),
"コパノリッキー" to setOf(2901,3203,103,7031,7032,2604,202,2010,2101,2601,3002,3003,3102,2530,2525,2501,2529,8672,8775,8829,8848,8994,9012,9079,9080,9081,9082,9083,9087,9088,9089,9090,9091,9092,9093,9094,9096,9097,9098,9099,9100,9101,9102,9104,9105,9106,9107,9108,9109,341,2532,2533,413,520,2711,3401,3505,3509,2411),
"ゴールドシチー" to setOf(104,202,320,2105,2601,2801,2902,3002,3101,3204,8009,8025,8060,8090,8126,8156,8170,8196,8211,8227,8243,8259,8285,8286,8295,8342,8363,8388,8406,8561,2521,8806,9037,9062,412,3501,3503,3507,2706,2403,2603,9245,9265),
"ゴールドシップ" to setOf(105,202,2101,2303,2601,7016,2904,3003,3004,3101,2523,2512,2506,2505,2515,3203,8033,8043,8072,8073,8074,8075,8076,8098,8109,8134,8145,8181,8268,8278,8303,8313,8320,8373,8420,2603,8432,8461,8497,8576,8662,8765,8819,8838,8984,9002,9111,9138,9203,407,523,525,528,2827,3401,3501,3503,3504,3506),
"サイレンススズカ" to setOf(104,202,301,402,2001,2601,7000,7001,7002,7013,7015,2810,2901,3003,3101,2512,3205,8017,8018,8019,8020,8021,8022,8023,8024,8025,8026,8027,8028,8029,8030,8031,8032,2406,2603,8444,8480,8512,8537,8641,518,8676,8700,8874,9152,523,525,526,2724,3506,3509),
"サクラチヨノオー" to setOf(104,201,324,511,512,2202,7025,7026,2802,2902,3002,3003,2510,2522,3202,8427,8428,8429,8430,8431,8432,8433,8434,8435,8436,8437,8438,8439,8440,8441,8442,8443,8444,8445,8446,8447,8448,8449,8450,8451,8452,8453,8454,8455,8456,8457,8458,8459,8460,2403,2604,8557,8594,8617,3101,2601,8697,8744,8779,8802,8852,8899,8931,8963,9000,9016,9033,9058,9090,9127,9182,9217,411,3501,3507,3509,9241,9261),
"サクラバクシンオー" to setOf(104,201,2003,2106,2601,2805,2902,3001,3101,2513,3204,8287,8288,8289,8290,8291,8292,8293,8294,8295,8296,8297,8298,8299,8300,8301,509,2404,2603,511,8441,8476,8508,8533,8570,8574,8637,2203,8788,8862,8869,9026,9227,411,2720,3508),
"サクラローレル" to setOf(511,2903,3004,3101,2506,3205,105,201,337,2601,2807,2523,8695,8696,8697,8698,8699,8700,8701,8702,8703,8704,8705,8706,8707,8708,8709,8710,8711,8712,407,3504,3506,2405,2603,9281),
"サトノダイヤモンド" to setOf(8465,8501,8580,8610,8611,8612,8613,8614,8615,8616,8617,8619,8620,8621,8622,8623,8624,8625,8626,8627,8628,8629,8630,2903,3004,3101,2523,2515,3201,2603,101,202,332,515,516,2601,7029,2824,8666,8769,8823,8842,8988,9006,9115,9142,9207,420,504,519,522,3501,3503,3504,3506),
"シリウスシンボリ" to setOf(8461,8462,8463,8464,8465,8466,8467,8468,8469,8470,8471,2902,3003,3101,2510,3203,2402,2604,106,201,325,2601,2818,8692,8729,8762,8917,8949,8981,9108,9168,9200,406,2712,3401,3506,3509),
"シンコウウインディ" to setOf(105,201,2601,2809,2902,3002,3102,2501,8010,8026,8061,8091,8127,8157,8171,8197,8212,8228,8244,8260,8296,8310,8311,8343,8364,8389,8407,8562,3204,8807,9038,9063,2406,347,2603,404,2720,3505,3509,9246,9266),
"シンボリクリスエス" to setOf(2903,2516,3201,201,105,2103,2207,2601,3003,3101,2523,2408,345,409,2822,3504,2604),
"シンボリルドルフ" to setOf(106,201,501,2201,2601,2702,2902,3003,3004,3101,2523,2510,2506,2505,2515,2519,3203,8005,8021,8056,8086,8122,8134,8135,8136,8137,8138,8139,8140,8141,8142,8143,8166,8207,8223,8239,8255,8281,8338,8376,8384,8423,2402,2604,8470,8585,8598,8621,2206,8748,8783,8834,8856,8903,8935,8967,9020,9049,9074,9094,9186,9221,406,524,3501,3503,3504,3506,9277),
"シーキングザパール" to setOf(106,202,319,2602,2810,2903,3001,3002,3101,2507,3204,8302,8303,8304,8305,8306,8307,8308,8309,8459,8527,8603,8626,2604,2706,8755,8910,8942,8974,9101,9193,2406,3506,3508,3509),
"スイープトウショウ" to setOf(101,202,2602,2904,3003,3101,2512,2514,2517,8312,8313,8314,8315,8316,8317,8318,8319,8460,8528,8604,8627,2603,335,519,2408,8756,8911,8943,8975,9102,9194,3205,419,3401,3502,3504,3509),
"スペシャルウィーク" to setOf(103,202,301,401,502,2001,2102,2301,2601,7003,7004,7005,7006,7007,2811,2903,3003,3004,3101,2510,2506,2516,2519,3205,8001,8002,8003,8004,8005,8006,8007,8008,8009,8010,8011,8012,8013,8014,8015,8016,2406,2603,510,8443,8479,8511,8536,8640,8675,8699,8873,9151,523,525,2725,3501,3503,3504),
"スマートファルコン" to setOf(105,202,318,2101,2601,2705,2901,3002,3003,3102,2530,2525,2531,2529,3204,8039,8049,8104,8113,8140,8149,8185,8272,8282,8307,8317,8326,8329,8330,8331,8332,8333,8377,8424,8434,8463,8499,8578,518,2010,8664,8767,8821,8840,8986,9004,9113,9140,9205,407,520,530,2826,3401,3505,3506,3508,3509,2409,2604),
"スーパークリーク" to setOf(106,202,321,506,2601,7011,7017,2802,2902,3003,3004,3101,2506,2516,2515,3205,8011,8027,8062,8070,8092,8112,8128,8148,8158,8172,8184,8198,8213,8229,8245,8261,8271,8297,8306,8316,8320,8321,8322,8323,8324,8325,8326,8327,8328,8344,8356,8390,8397,8408,2403,2603,8556,8593,8616,8696,8743,8778,8801,8851,8898,8930,8962,8999,9015,9032,9057,9089,9126,9181,9216,405,2727,2503,3503,3504,9240,9260),
"セイウンスカイ" to setOf(103,201,401,502,2601,7006,7024,2811,2901,3003,3004,3101,2505,2515,3204,8152,8153,8154,8155,8156,8157,8158,8159,8160,8161,8438,8474,8505,8531,8635,337,8725,8867,2603,535,2723,3501,3504,2406),
"ゼンノロブロイ" to setOf(102,201,313,2601,2902,3003,3101,2523,2516,2519,8334,8335,8336,8337,8338,8339,8340,8341,8342,8343,8344,8345,8346,8347,8348,8349,8453,8489,8521,8546,8650,2603,2001,8685,8709,8883,9161,2408,3203,2701,417,550,2823,3501,3503,3504,3506),
"タイキシャトル" to setOf(104,201,304,402,2601,2810,2902,3001,3002,3101,2511,2518,2513,3203,8082,8083,8084,8085,8086,8087,8088,8089,8090,8091,8092,8093,8094,8095,8096,8097,2406,2604,8446,8482,8514,8539,8643,8678,8702,8876,9154,524,534,3506,3508,3509),
"タニノギムレット" to setOf(2904,2510,3205,338,105,202,2009,3003,3101,2408,409,2822,3501,3509,2603,2210,2601),
"タマモクロス" to setOf(106,202,302,506,2601,7009,7017,2801,2904,3003,3004,3101,2512,2506,2516,3205,8036,8046,8073,8078,8101,8137,8191,8290,8323,8330,8351,8401,8428,8493,8550,8588,8611,2403,8654,8714,8734,8792,8889,8921,8953,9080,9130,9172,2604,405,551,3503,3504,9231,9283),
"ダイイチルビー" to setOf(3001,3002,2404,104,339,2602,2803,202,2008,2110,3101,2511,2513,3204,8790,8791,8792,8793,8794,8795,8797,8798,8799,8800,8801,8802,8803,8804,8805,8806,8807,8808,8809,8810,8811,8812,8813,8814,8815,8816,8817,2903,412,504,521,2721,3508,3509,2604),
"ダイタクヘリオス" to setOf(8572,8573,8574,8575,3002,3101,2518,3204,2404,2604,105,202,330,514,2108,2601,2803,8817,2902,408,521,526,2716,3504,3508,3509,9256),
"ダイワスカーレット" to setOf(102,202,303,403,2101,2106,2602,7012,2815,2902,3002,3003,3101,2523,2514,2504,2517,3205,8034,8044,8077,8078,8079,8080,8081,8099,8110,8135,8146,8182,8269,8279,8304,8314,8321,8374,8421,2409,2604,8433,8462,8498,8577,8663,8766,8820,8839,8985,9003,9112,9139,9204,525,2503,3502,3504,3509),
"ツインターボ" to setOf(8576,8577,8578,8579,8580,8581,8582,8583,8584,8585,8586,2901,3003,3101,3204,2404,2603,102,201,331,513,2601,7028,2804,2110,8693,8730,8763,8918,8950,8982,9109,9169,9201,403,526,2719,3301,3401,3504,3505),
"テイエムオペラオー" to setOf(103,202,306,2104,2601,7005,2702,2812,2902,3003,3004,3101,2523,2512,2506,2516,2505,2519,3203,8004,8020,8055,8085,8116,8117,8121,8153,8165,8189,8206,8222,8238,8254,8288,8337,8358,8383,8399,8559,8804,9035,9060,2603,414,524,537,3501,3503,3504,2407,9243,9263),
"トウカイテイオー" to setOf(102,202,308,403,2201,2601,7008,7022,2804,2902,3003,3101,2523,2510,2505,2519,3204,8001,8017,8033,8034,8035,8036,8037,8038,8039,8040,8041,8042,8052,8082,8118,8162,8203,8219,8235,8251,8277,8334,8372,8380,8419,2404,2604,8468,8583,8596,8619,517,7028,2007,8746,8781,8832,8854,8901,8933,8965,9018,9047,9072,9092,9184,9219,525,2503,3501,3503,3504,9275),
"トーセンジョーダン" to setOf(104,202,316,2601,2816,2902,3003,3101,2516,8040,8050,8076,8081,8105,8141,8199,8298,8327,8333,8354,8409,8431,8496,8553,8591,8614,3202,2106,2208,8657,8717,8737,8795,8892,8924,8956,9083,9133,9175,412,3401,3503,3504,2410,2604,9234,9286),
"ナイスネイチャ" to setOf(103,202,323,2601,7022,2706,2804,2903,3003,3004,3101,3204,8016,8032,8067,8097,8133,8161,8177,8202,8218,8234,8250,8266,8301,8349,8370,8395,8412,8417,8418,2404,2603,8564,513,8809,9040,9065,415,533,3301,3401,3503,3504,9248,9268),
"ナカヤマフェスタ" to setOf(104,201,2601,2816,2903,3003,3101,2512,8041,8051,8106,8114,8142,8150,8186,8273,8283,8308,8318,8328,8350,8351,8352,8353,8354,8378,8425,8435,8464,8500,8579,325,2604,2101,3204,8665,8768,8822,8841,8987,9005,9114,9141,9206,2410,412,3501,3506),
"ナリタタイシン" to setOf(105,202,321,404,507,2601,7019,7021,2806,2904,3003,3101,2505,3206,8042,8107,8117,8143,8179,8276,8284,8286,8311,8355,8356,8365,8379,8414,8416,8418,8426,8437,8467,8473,8504,8530,8554,8572,8582,8634,8674,8722,8831,8866,9150,2524,3501,3503,3507,2405,2603,9291),
"ナリタトップロード" to setOf(2902,3003,2515,3204,105,202,340,2407,2109,2601,2705,2812,3004,3101,8713,8714,8715,8716,8717,8718,8719,8720,8721,8722,404,3401,3501,3504,2604,2011),
"ナリタブライアン" to setOf(105,202,501,2601,2807,2903,3003,3004,3101,2523,2510,2522,2505,2515,3205,8118,8119,8120,8121,8122,8123,8124,8125,8126,8127,8128,8129,8130,8131,8132,8133,8447,8483,8515,8540,8644,338,2009,8679,8703,8877,9155,2604,407,523,524,3501,3504,3507,3509,2405),
"ニシノフラワー" to setOf(101,202,310,2602,2805,2902,3001,3002,3101,2504,2521,2513,8357,8358,8359,8360,8361,8362,8363,8364,8365,8366,8367,8368,8369,8370,8371,8471,8491,8548,8586,8652,2404,2604,8732,8837,8887,419,2722,3502,3507,3508,3509,3204),
"ネオユニヴァース" to setOf(2510,2505,2903,3101,202,348,410,2823,2503,3501,3503,2408,2603,104,2001,2209,2601,3003,3205,9257,9258,9259,9260,9261,9262,9263,9264,9265,9266,9267,9268,9269,9270,9271,9272,9273,9274,9275,9276,9277,9278,9279,9280,9281),
"ハルウララ" to setOf(103,202,322,2602,2812,2904,3001,3102,3202,8366,8372,8373,8374,8375,8376,8377,8378,8379,508,509,2407,2603,510,8606,8629,8690,8727,8760,8915,8947,8979,9106,9166,9198,414,527,528,529,530,531,532,533,534,535,536,537,538,539,540,541,542,543,544,545,546,547,548,549,550,551,2707,3301,3401,3505,3508),
"バンブーメモリー" to setOf(105,202,320,2601,2802,2903,3001,3002,3101,2511,2513,8367,2604,2403,409,3401,3504,3508,3509,3205),
"ヒシアケボノ" to setOf(103,202,312,2601,2808,2902,3001,3101,2513,8180,8181,8182,8183,8184,8185,8186,8187,512,8457,8525,8601,8624,3202,8753,8908,8940,8972,9099,9191,2603,413,2707,3505,3508,2405),
"ヒシアマゾン" to setOf(105,201,505,2602,7014,7015,2807,2904,3003,3101,2521,2517,3203,8357,2603,407,524,2712,3504,3507,3509,2405),
"ヒシミラクル" to setOf(2903,202,346,409,549,2713,2822,2512,2506,2515,3401,3503,3504,3203,2604,2408,105,2011,2601,3004,3101,9282,9283,9284,9285,9286,9287,9288,9289,9290,9291),
"ビワハヤヒデ" to setOf(105,202,306,404,507,2601,7018,7019,2703,2806,2902,3003,3004,3101,2512,2506,2515,3203,8037,8047,8074,8079,8102,8138,8192,8291,8324,8331,8352,8402,8429,8494,8551,8589,8612,8655,8715,8735,8793,8890,8922,8954,9081,9131,9173,2603,3501,3503,3504,2405,9232,9284),
"ファインモーション" to setOf(104,202,307,504,2602,2902,3003,3101,2514,2517,3201,8006,8022,8057,8069,8087,8111,8123,8147,8167,8183,8208,8224,8240,8256,8270,8305,8315,8339,8385,2408,8723,8996,9029,9054,9123,2604,402,542,2822,3509,9257),
"フジキセキ" to setOf(105,202,505,2001,2601,2808,2902,3002,3101,2522,3204,8052,8053,8054,8055,8056,8057,8058,8059,8060,8061,8062,8063,8064,8065,8066,8067,8445,8481,8513,8538,8642,8677,8701,8875,9153,2604,407,524,2721,3507,3509,2405),
"ホッコータルマエ" to setOf(3205,103,7031,202,2601,7033,3002,3003,3102,2525,2531,2529,8758,8913,8945,8977,9104,9111,9112,9113,9114,9115,9116,9122,9123,9124,9125,9126,9127,9128,344,2411,2533,2902,2603,2530,2520,413,520,2827,3401,3505,3506,3509),
"マチカネタンホイザ" to setOf(8529,8530,8531,8532,8533,8534,8535,8536,8537,8538,8539,8540,8541,8542,8543,8544,8545,8546,8547,8548,2903,3004,3101,3205,2404,2604,103,202,327,513,2601,2805,8814,9045,9070,415,2726,3301,3401,3501,3503,3504,3509,9253,9273),
"マチカネフクキタル" to setOf(104,202,402,2601,7002,2810,2903,3003,3101,2515,3205,8013,8029,8064,8094,8130,8174,8215,8231,8247,8263,8346,8392,8396,8397,2406,2603,8439,8506,327,9052,9077,539,3401,3501,3503,9280),
"マヤノトップガン" to setOf(101,202,308,2103,2104,2601,2808,2901,3003,3004,3101,2523,2512,2506,2515,3203,2405,2603,2009,419,531,2711,3503,3504),
"マルゼンスキー" to setOf(106,203,2301,2302,2601,2901,3001,3002,3101,2522,3205,8002,8018,8043,8044,8045,8046,8047,8048,8049,8050,8051,8053,8068,8083,8108,8119,8144,8152,8163,8180,8188,8204,8220,8236,8252,8267,8287,8302,8312,8335,8355,8381,8396,8398,2401,2604,2202,8555,8592,8615,2205,8695,8742,8777,8800,8850,8897,8929,8961,8998,9014,9031,9056,9088,9125,9180,9215,406,518,524,3507,3509,9239,9259),
"マンハッタンカフェ" to setOf(104,201,309,2001,2601,2704,2814,2903,3004,3101,2523,2506,2515,3203,8162,8163,8164,8165,8166,8167,8168,8169,8170,8171,8172,8173,8174,8175,8176,8177,8448,8484,8516,8541,8645,8680,8704,8878,9156,2603,410,3506,2407),
"マーベラスサンデー" to setOf(102,202,323,2601,2808,3003,3101,2512,8380,8381,8382,8383,8384,8385,8386,8387,8388,8389,8390,8391,8392,8393,8394,8395,8454,8490,8522,8547,8651,2001,8686,8710,8884,9162,2903,3205,417,2503,3503,3504,2405,2603),
"ミスターシービー" to setOf(205,2601,2904,3003,3101,2510,2516,2505,2515,3204,8398,8399,8400,8401,8402,8403,8404,8405,8406,8407,8408,8409,8410,8411,8412,8442,8477,8509,8534,8571,8575,8638,106,2008,8789,8863,8870,9027,9228,2603,406,2825,3501,3503,3504,3509,2402),
"ミホノブルボン" to setOf(104,202,310,2601,2805,2901,3001,3002,3003,3101,2510,2522,2505,3204,2604,411,518,3501,3507,2404),
"メイショウドトウ" to setOf(103,202,317,2601,2812,2902,3003,3101,2512,8014,8030,8065,8095,8131,8159,8175,8200,8216,8232,8248,8264,8299,8347,8368,8393,8410,8413,8414,8563,2109,2111,8808,9039,9064,414,540,3503,3504,3203,2407,2603,9247,9267),
"メジロアルダン" to setOf(324,7025,7027,2802,8472,8473,8474,8475,8476,8477,8478,8479,8480,8481,8482,8483,8484,8485,8486,8487,8488,8489,8490,8491,2902,3003,3101,3203,2403,2603,106,201,326,2108,2601,503,8813,9044,9069,405,504,3301,3504,9252,9272),
"メジロドーベル" to setOf(104,201,304,503,2602,2810,2903,3002,3003,3101,2509,2514,2521,2517,8015,8031,8066,8096,8132,8160,8176,8201,8217,8233,8249,8265,8300,8348,8369,8394,8411,8415,8416,8566,2004,7030,8812,9043,9068,402,532,3502,3503,3507,3509,3205,2406,2604,9251,9271),
"メジロパーマー" to setOf(8478,8510,8535,8555,8556,8557,8559,8560,8561,8562,8563,8564,8565,8566,8569,8570,8571,8639,2901,3003,3004,3101,2523,2512,3203,2404,2603,105,202,329,514,2601,2803,503,8816,8872,408,526,2710,3401,3503,3504,9255),
"メジロブライト" to setOf(8633,8634,8635,8636,8637,8638,8639,8640,8641,8642,8643,8644,8645,8646,8647,8648,8649,8650,8651,8652,2903,3004,3101,2506,3204,2406,2603,104,202,333,2004,2204,2205,2601,7030,2810,503,8815,9046,9071,402,2722,2524,3401,3501,3503,3504,3507,9254,9274),
"メジロマックイーン" to setOf(102,202,403,503,504,2303,2601,7008,7016,2803,2902,3003,3004,3101,2512,2506,2515,3204,8003,8019,8054,8084,8098,8099,8100,8101,8102,8103,8104,8105,8106,8107,8120,8164,8205,8221,8237,8253,8280,8336,8375,8382,8422,2404,2603,8469,8584,8597,8620,328,516,8747,8782,8833,8855,8902,8934,8966,9019,9048,9073,9093,9185,9220,523,525,2503,3503,3504,9276),
"メジロライアン" to setOf(105,201,311,503,2601,7010,7020,2803,2903,3003,3101,2512,3204,8007,8023,8058,8088,8124,8154,8168,8178,8179,8193,8209,8225,8241,8257,8292,8340,8359,8386,8403,2404,2603,8565,2204,8811,9042,9067,408,2717,3501,3503,9250,9270),
"メジロラモーヌ" to setOf(2902,3002,106,201,2602,503,3003,3101,2509,2504,2517,3204,8694,8731,8764,8819,8820,8821,8822,8823,8824,8826,8827,8828,8829,8830,8831,8832,8833,8834,8836,8837,345,406,504,2715,3502,3509,2403,2603),
"ヤエノムテキ" to setOf(7026,7027,2802,8492,8493,8494,8495,8496,8497,8498,8499,8500,8501,8502,8503,8504,8505,8506,8507,8508,8509,8510,8511,8512,8513,8514,8515,8516,8517,8518,8519,8520,8521,8522,8523,8524,8525,8526,8527,8528,2902,3003,3101,2516,2505,3204,2403,2604,105,202,334,2601,8698,8745,8780,8803,8853,8900,8932,8964,9001,9017,9034,9059,9091,9128,9183,9218,409,2717,2503,3501,3503,3504,9242,9262),
"ヤマニンゼファー" to setOf(2902,3001,3002,3205,102,201,2804,2604,2601,8723,8724,8725,8726,8727,8728,8729,8730,8731,342,3101,2516,2511,2404,416,521,2727,3508,3509),
"ユキノビジン" to setOf(102,201,309,2003,2107,2602,2703,2806,2902,3002,3003,3101,3203,8188,8189,8190,8191,8192,8193,8194,8195,8196,8197,8198,8199,8200,8201,8202,8440,8475,8507,8532,8569,8573,8636,2603,8787,8861,8868,9025,9226,2405,416,3301,3502,3505),
"ライスシャワー" to setOf(104,201,313,2601,2704,2805,2902,3003,3004,3101,2506,2515,3203,8203,8204,8205,8206,8207,8208,8209,8210,8211,8212,8213,8214,8215,8216,8217,8218,508,2404,2604,8449,8485,8517,8542,8646,8681,8705,8879,9157,411,523,3401,3501,3503,3504),
"ワンダーアキュート" to setOf(2603,7032,104,2601,7033,2816,3002,3003,3102,2525,2529,3203,2410,343,2533,2902,202,412,520,547,2708,3401,3505,3509),
    )

    val relation: Map<Int, Int> = mapOf(
101 to 2,
102 to 2,
103 to 2,
104 to 2,
105 to 2,
106 to 2,
107 to 2,
201 to 2,
202 to 2,
203 to 2,
204 to 2,
205 to 2,
301 to 2,
302 to 2,
303 to 2,
304 to 2,
305 to 2,
306 to 2,
307 to 2,
308 to 2,
309 to 2,
310 to 2,
311 to 2,
312 to 2,
313 to 2,
314 to 2,
315 to 2,
316 to 2,
317 to 2,
318 to 2,
319 to 2,
320 to 2,
321 to 2,
322 to 2,
323 to 2,
324 to 2,
325 to 2,
326 to 2,
327 to 2,
328 to 2,
329 to 2,
330 to 2,
331 to 2,
332 to 2,
333 to 2,
334 to 2,
335 to 2,
336 to 2,
337 to 2,
338 to 2,
339 to 2,
340 to 2,
341 to 2,
342 to 2,
343 to 2,
344 to 2,
345 to 2,
346 to 2,
347 to 2,
348 to 2,
349 to 2,
350 to 2,
351 to 2,
352 to 2,
353 to 2,
354 to 2,
355 to 2,
356 to 2,
357 to 2,
358 to 2,
359 to 2,
360 to 2,
361 to 2,
362 to 2,
363 to 2,
364 to 2,
365 to 2,
366 to 2,
367 to 2,
368 to 2,
369 to 2,
370 to 2,
371 to 2,
372 to 2,
373 to 2,
374 to 2,
375 to 2,
376 to 2,
377 to 2,
378 to 2,
379 to 2,
380 to 2,
381 to 2,
382 to 2,
383 to 2,
384 to 2,
385 to 2,
386 to 2,
387 to 2,
388 to 2,
401 to 2,
402 to 2,
403 to 2,
404 to 2,
405 to 2,
406 to 2,
407 to 2,
408 to 2,
409 to 2,
410 to 2,
411 to 2,
412 to 2,
413 to 2,
414 to 2,
415 to 2,
416 to 2,
417 to 2,
418 to 2,
419 to 2,
420 to 2,
501 to 2,
502 to 2,
503 to 2,
504 to 2,
505 to 2,
506 to 2,
507 to 2,
508 to 8,
509 to 8,
510 to 8,
511 to 2,
512 to 2,
513 to 2,
514 to 2,
515 to 2,
516 to 2,
517 to 2,
518 to 2,
519 to 2,
520 to 2,
521 to 2,
522 to 2,
523 to 2,
524 to 2,
525 to 2,
526 to 2,
527 to 8,
528 to 8,
529 to 8,
530 to 8,
531 to 8,
532 to 8,
533 to 8,
534 to 8,
535 to 8,
536 to 8,
537 to 8,
538 to 8,
539 to 8,
540 to 8,
541 to 8,
542 to 8,
543 to 8,
544 to 8,
545 to 8,
546 to 8,
547 to 8,
548 to 8,
549 to 8,
550 to 8,
551 to 8,
2001 to 1,
2002 to 1,
2003 to 1,
2004 to 1,
2005 to 1,
2006 to 1,
2007 to 1,
2008 to 1,
2009 to 1,
2010 to 1,
2011 to 1,
2101 to 1,
2102 to 1,
2103 to 1,
2104 to 1,
2105 to 1,
2106 to 1,
2107 to 1,
2108 to 1,
2109 to 1,
2110 to 1,
2111 to 1,
2112 to 1,
2113 to 1,
2114 to 1,
2201 to 1,
2202 to 1,
2203 to 1,
2204 to 1,
2205 to 1,
2206 to 1,
2207 to 1,
2208 to 1,
2209 to 1,
2210 to 1,
2211 to 1,
2212 to 1,
2301 to 1,
2302 to 1,
2303 to 1,
2401 to 1,
2402 to 1,
2403 to 1,
2404 to 1,
2405 to 1,
2406 to 1,
2407 to 1,
2408 to 1,
2409 to 1,
2410 to 1,
2411 to 1,
2501 to 1,
2502 to 1,
2503 to 1,
2504 to 1,
2505 to 1,
2506 to 1,
2507 to 1,
2508 to 1,
2509 to 1,
2510 to 1,
2511 to 1,
2512 to 1,
2513 to 1,
2514 to 1,
2515 to 1,
2516 to 1,
2517 to 1,
2518 to 1,
2519 to 1,
2520 to 1,
2521 to 1,
2522 to 1,
2523 to 1,
2524 to 1,
2525 to 1,
2526 to 1,
2527 to 1,
2528 to 1,
2529 to 1,
2530 to 1,
2531 to 1,
2532 to 1,
2533 to 1,
2534 to 1,
2601 to 1,
2602 to 1,
2603 to 1,
2604 to 1,
2701 to 1,
2702 to 1,
2703 to 1,
2704 to 1,
2705 to 1,
2706 to 1,
2707 to 1,
2708 to 1,
2709 to 1,
2710 to 1,
2711 to 1,
2712 to 1,
2713 to 1,
2714 to 1,
2715 to 1,
2716 to 1,
2717 to 1,
2718 to 1,
2719 to 1,
2720 to 1,
2721 to 1,
2722 to 1,
2723 to 1,
2724 to 1,
2725 to 1,
2726 to 1,
2727 to 1,
2801 to 1,
2802 to 1,
2803 to 1,
2804 to 1,
2805 to 1,
2806 to 1,
2807 to 1,
2808 to 1,
2809 to 1,
2810 to 1,
2811 to 1,
2812 to 1,
2813 to 1,
2814 to 1,
2815 to 1,
2816 to 1,
2817 to 1,
2818 to 1,
2819 to 1,
2820 to 1,
2821 to 1,
2822 to 1,
2823 to 1,
2824 to 1,
2825 to 1,
2826 to 1,
2827 to 1,
2828 to 1,
2901 to 7,
2902 to 7,
2903 to 7,
2904 to 7,
3001 to 7,
3002 to 7,
3003 to 7,
3004 to 7,
3101 to 7,
3102 to 7,
3201 to 1,
3202 to 1,
3203 to 1,
3204 to 1,
3205 to 1,
3206 to 1,
3301 to 1,
3401 to 1,
3501 to 1,
3502 to 1,
3503 to 1,
3504 to 1,
3505 to 2,
3506 to 2,
3507 to 1,
3508 to 2,
3509 to 1,
5001 to 1,
5002 to 1,
7000 to 1,
7001 to 1,
7002 to 1,
7003 to 1,
7004 to 1,
7005 to 1,
7006 to 1,
7007 to 1,
7008 to 1,
7009 to 1,
7010 to 1,
7011 to 1,
7012 to 1,
7013 to 1,
7014 to 1,
7015 to 1,
7016 to 1,
7017 to 1,
7018 to 1,
7019 to 1,
7020 to 1,
7021 to 1,
7022 to 1,
7023 to 1,
7024 to 1,
7025 to 1,
7026 to 1,
7027 to 1,
7028 to 1,
7029 to 1,
7030 to 1,
7031 to 1,
7032 to 1,
7033 to 1,
7034 to 1,
7035 to 1,
7036 to 1,
7037 to 1,
7038 to 1,
7039 to 1,
7040 to 1,
7041 to 1,
7042 to 1,
7043 to 1,
7044 to 1,
7045 to 1,
7046 to 1,
8001 to 1,
8002 to 1,
8003 to 1,
8004 to 1,
8005 to 1,
8006 to 1,
8007 to 1,
8008 to 1,
8009 to 1,
8010 to 1,
8011 to 1,
8012 to 1,
8013 to 1,
8014 to 1,
8015 to 1,
8016 to 1,
8017 to 1,
8018 to 1,
8019 to 1,
8020 to 1,
8021 to 1,
8022 to 1,
8023 to 1,
8024 to 1,
8025 to 1,
8026 to 1,
8027 to 1,
8028 to 1,
8029 to 1,
8030 to 1,
8031 to 1,
8032 to 1,
8033 to 1,
8034 to 1,
8035 to 1,
8036 to 1,
8037 to 1,
8038 to 1,
8039 to 1,
8040 to 1,
8041 to 1,
8042 to 1,
8043 to 1,
8044 to 1,
8045 to 1,
8046 to 1,
8047 to 1,
8048 to 1,
8049 to 1,
8050 to 1,
8051 to 1,
8052 to 1,
8053 to 1,
8054 to 1,
8055 to 1,
8056 to 1,
8057 to 1,
8058 to 1,
8059 to 1,
8060 to 1,
8061 to 1,
8062 to 1,
8063 to 1,
8064 to 1,
8065 to 1,
8066 to 1,
8067 to 1,
8068 to 1,
8069 to 1,
8070 to 1,
8071 to 1,
8072 to 1,
8073 to 1,
8074 to 1,
8075 to 1,
8076 to 1,
8077 to 1,
8078 to 1,
8079 to 1,
8080 to 1,
8081 to 1,
8082 to 1,
8083 to 1,
8084 to 1,
8085 to 1,
8086 to 1,
8087 to 1,
8088 to 1,
8089 to 1,
8090 to 1,
8091 to 1,
8092 to 1,
8093 to 1,
8094 to 1,
8095 to 1,
8096 to 1,
8097 to 1,
8098 to 1,
8099 to 1,
8100 to 1,
8101 to 1,
8102 to 1,
8103 to 1,
8104 to 1,
8105 to 1,
8106 to 1,
8107 to 1,
8108 to 1,
8109 to 1,
8110 to 1,
8111 to 1,
8112 to 1,
8113 to 1,
8114 to 1,
8115 to 1,
8116 to 1,
8117 to 1,
8118 to 1,
8119 to 1,
8120 to 1,
8121 to 1,
8122 to 1,
8123 to 1,
8124 to 1,
8125 to 1,
8126 to 1,
8127 to 1,
8128 to 1,
8129 to 1,
8130 to 1,
8131 to 1,
8132 to 1,
8133 to 1,
8134 to 1,
8135 to 1,
8136 to 1,
8137 to 1,
8138 to 1,
8139 to 1,
8140 to 1,
8141 to 1,
8142 to 1,
8143 to 1,
8144 to 1,
8145 to 1,
8146 to 1,
8147 to 1,
8148 to 1,
8149 to 1,
8150 to 1,
8151 to 1,
8152 to 1,
8153 to 1,
8154 to 1,
8155 to 1,
8156 to 1,
8157 to 1,
8158 to 1,
8159 to 1,
8160 to 1,
8161 to 1,
8162 to 1,
8163 to 1,
8164 to 1,
8165 to 1,
8166 to 1,
8167 to 1,
8168 to 1,
8169 to 1,
8170 to 1,
8171 to 1,
8172 to 1,
8173 to 1,
8174 to 1,
8175 to 1,
8176 to 1,
8177 to 1,
8178 to 1,
8179 to 1,
8180 to 1,
8181 to 1,
8182 to 1,
8183 to 1,
8184 to 1,
8185 to 1,
8186 to 1,
8187 to 1,
8188 to 1,
8189 to 1,
8190 to 1,
8191 to 1,
8192 to 1,
8193 to 1,
8194 to 1,
8195 to 1,
8196 to 1,
8197 to 1,
8198 to 1,
8199 to 1,
8200 to 1,
8201 to 1,
8202 to 1,
8203 to 1,
8204 to 1,
8205 to 1,
8206 to 1,
8207 to 1,
8208 to 1,
8209 to 1,
8210 to 1,
8211 to 1,
8212 to 1,
8213 to 1,
8214 to 1,
8215 to 1,
8216 to 1,
8217 to 1,
8218 to 1,
8219 to 1,
8220 to 1,
8221 to 1,
8222 to 1,
8223 to 1,
8224 to 1,
8225 to 1,
8226 to 1,
8227 to 1,
8228 to 1,
8229 to 1,
8230 to 1,
8231 to 1,
8232 to 1,
8233 to 1,
8234 to 1,
8235 to 1,
8236 to 1,
8237 to 1,
8238 to 1,
8239 to 1,
8240 to 1,
8241 to 1,
8242 to 1,
8243 to 1,
8244 to 1,
8245 to 1,
8246 to 1,
8247 to 1,
8248 to 1,
8249 to 1,
8250 to 1,
8251 to 1,
8252 to 1,
8253 to 1,
8254 to 1,
8255 to 1,
8256 to 1,
8257 to 1,
8258 to 1,
8259 to 1,
8260 to 1,
8261 to 1,
8262 to 1,
8263 to 1,
8264 to 1,
8265 to 1,
8266 to 1,
8267 to 1,
8268 to 1,
8269 to 1,
8270 to 1,
8271 to 1,
8272 to 1,
8273 to 1,
8274 to 1,
8275 to 1,
8276 to 1,
8277 to 1,
8278 to 1,
8279 to 1,
8280 to 1,
8281 to 1,
8282 to 1,
8283 to 1,
8284 to 1,
8285 to 1,
8286 to 1,
8287 to 1,
8288 to 1,
8289 to 1,
8290 to 1,
8291 to 1,
8292 to 1,
8293 to 1,
8294 to 1,
8295 to 1,
8296 to 1,
8297 to 1,
8298 to 1,
8299 to 1,
8300 to 1,
8301 to 1,
8302 to 1,
8303 to 1,
8304 to 1,
8305 to 1,
8306 to 1,
8307 to 1,
8308 to 1,
8309 to 1,
8310 to 1,
8311 to 1,
8312 to 1,
8313 to 1,
8314 to 1,
8315 to 1,
8316 to 1,
8317 to 1,
8318 to 1,
8319 to 1,
8320 to 1,
8321 to 1,
8322 to 1,
8323 to 1,
8324 to 1,
8325 to 1,
8326 to 1,
8327 to 1,
8328 to 1,
8329 to 1,
8330 to 1,
8331 to 1,
8332 to 1,
8333 to 1,
8334 to 1,
8335 to 1,
8336 to 1,
8337 to 1,
8338 to 1,
8339 to 1,
8340 to 1,
8341 to 1,
8342 to 1,
8343 to 1,
8344 to 1,
8345 to 1,
8346 to 1,
8347 to 1,
8348 to 1,
8349 to 1,
8350 to 1,
8351 to 1,
8352 to 1,
8353 to 1,
8354 to 1,
8355 to 1,
8356 to 1,
8357 to 1,
8358 to 1,
8359 to 1,
8360 to 1,
8361 to 1,
8362 to 1,
8363 to 1,
8364 to 1,
8365 to 1,
8366 to 1,
8367 to 1,
8368 to 1,
8369 to 1,
8370 to 1,
8371 to 1,
8372 to 1,
8373 to 1,
8374 to 1,
8375 to 1,
8376 to 1,
8377 to 1,
8378 to 1,
8379 to 1,
8380 to 1,
8381 to 1,
8382 to 1,
8383 to 1,
8384 to 1,
8385 to 1,
8386 to 1,
8387 to 1,
8388 to 1,
8389 to 1,
8390 to 1,
8391 to 1,
8392 to 1,
8393 to 1,
8394 to 1,
8395 to 1,
8396 to 1,
8397 to 1,
8398 to 1,
8399 to 1,
8400 to 1,
8401 to 1,
8402 to 1,
8403 to 1,
8404 to 1,
8405 to 1,
8406 to 1,
8407 to 1,
8408 to 1,
8409 to 1,
8410 to 1,
8411 to 1,
8412 to 1,
8413 to 1,
8414 to 1,
8415 to 1,
8416 to 1,
8417 to 1,
8418 to 1,
8419 to 1,
8420 to 1,
8421 to 1,
8422 to 1,
8423 to 1,
8424 to 1,
8425 to 1,
8426 to 1,
8427 to 1,
8428 to 1,
8429 to 1,
8430 to 1,
8431 to 1,
8432 to 1,
8433 to 1,
8434 to 1,
8435 to 1,
8436 to 1,
8437 to 1,
8438 to 1,
8439 to 1,
8440 to 1,
8441 to 1,
8442 to 1,
8443 to 1,
8444 to 1,
8445 to 1,
8446 to 1,
8447 to 1,
8448 to 1,
8449 to 1,
8450 to 1,
8451 to 1,
8452 to 1,
8453 to 1,
8454 to 1,
8455 to 1,
8456 to 1,
8457 to 1,
8458 to 1,
8459 to 1,
8460 to 1,
8461 to 1,
8462 to 1,
8463 to 1,
8464 to 1,
8465 to 1,
8466 to 1,
8467 to 1,
8468 to 1,
8469 to 1,
8470 to 1,
8471 to 1,
8472 to 1,
8473 to 1,
8474 to 1,
8475 to 1,
8476 to 1,
8477 to 1,
8478 to 1,
8479 to 1,
8480 to 1,
8481 to 1,
8482 to 1,
8483 to 1,
8484 to 1,
8485 to 1,
8486 to 1,
8487 to 1,
8488 to 1,
8489 to 1,
8490 to 1,
8491 to 1,
8492 to 1,
8493 to 1,
8494 to 1,
8495 to 1,
8496 to 1,
8497 to 1,
8498 to 1,
8499 to 1,
8500 to 1,
8501 to 1,
8502 to 1,
8503 to 1,
8504 to 1,
8505 to 1,
8506 to 1,
8507 to 1,
8508 to 1,
8509 to 1,
8510 to 1,
8511 to 1,
8512 to 1,
8513 to 1,
8514 to 1,
8515 to 1,
8516 to 1,
8517 to 1,
8518 to 1,
8519 to 1,
8520 to 1,
8521 to 1,
8522 to 1,
8523 to 1,
8524 to 1,
8525 to 1,
8526 to 1,
8527 to 1,
8528 to 1,
8529 to 1,
8530 to 1,
8531 to 1,
8532 to 1,
8533 to 1,
8534 to 1,
8535 to 1,
8536 to 1,
8537 to 1,
8538 to 1,
8539 to 1,
8540 to 1,
8541 to 1,
8542 to 1,
8543 to 1,
8544 to 1,
8545 to 1,
8546 to 1,
8547 to 1,
8548 to 1,
8549 to 1,
8550 to 1,
8551 to 1,
8552 to 1,
8553 to 1,
8554 to 1,
8555 to 1,
8556 to 1,
8557 to 1,
8558 to 1,
8559 to 1,
8560 to 1,
8561 to 1,
8562 to 1,
8563 to 1,
8564 to 1,
8565 to 1,
8566 to 1,
8567 to 1,
8568 to 1,
8569 to 1,
8570 to 1,
8571 to 1,
8572 to 1,
8573 to 1,
8574 to 1,
8575 to 1,
8576 to 1,
8577 to 1,
8578 to 1,
8579 to 1,
8580 to 1,
8581 to 1,
8582 to 1,
8583 to 1,
8584 to 1,
8585 to 1,
8586 to 1,
8587 to 1,
8588 to 1,
8589 to 1,
8590 to 1,
8591 to 1,
8592 to 1,
8593 to 1,
8594 to 1,
8595 to 1,
8596 to 1,
8597 to 1,
8598 to 1,
8599 to 1,
8600 to 1,
8601 to 1,
8602 to 1,
8603 to 1,
8604 to 1,
8605 to 1,
8606 to 1,
8607 to 1,
8608 to 1,
8609 to 1,
8610 to 1,
8611 to 1,
8612 to 1,
8613 to 1,
8614 to 1,
8615 to 1,
8616 to 1,
8617 to 1,
8618 to 1,
8619 to 1,
8620 to 1,
8621 to 1,
8622 to 1,
8623 to 1,
8624 to 1,
8625 to 1,
8626 to 1,
8627 to 1,
8628 to 1,
8629 to 1,
8630 to 1,
8631 to 1,
8632 to 1,
8633 to 1,
8634 to 1,
8635 to 1,
8636 to 1,
8637 to 1,
8638 to 1,
8639 to 1,
8640 to 1,
8641 to 1,
8642 to 1,
8643 to 1,
8644 to 1,
8645 to 1,
8646 to 1,
8647 to 1,
8648 to 1,
8649 to 1,
8650 to 1,
8651 to 1,
8652 to 1,
8653 to 1,
8654 to 1,
8655 to 1,
8656 to 1,
8657 to 1,
8658 to 1,
8659 to 1,
8660 to 1,
8661 to 1,
8662 to 1,
8663 to 1,
8664 to 1,
8665 to 1,
8666 to 1,
8667 to 1,
8668 to 1,
8669 to 1,
8670 to 1,
8671 to 1,
8672 to 1,
8673 to 1,
8674 to 1,
8675 to 1,
8676 to 1,
8677 to 1,
8678 to 1,
8679 to 1,
8680 to 1,
8681 to 1,
8682 to 1,
8683 to 1,
8684 to 1,
8685 to 1,
8686 to 1,
8687 to 1,
8688 to 1,
8689 to 1,
8690 to 1,
8691 to 1,
8692 to 1,
8693 to 1,
8694 to 1,
8695 to 1,
8696 to 1,
8697 to 1,
8698 to 1,
8699 to 1,
8700 to 1,
8701 to 1,
8702 to 1,
8703 to 1,
8704 to 1,
8705 to 1,
8706 to 1,
8707 to 1,
8708 to 1,
8709 to 1,
8710 to 1,
8711 to 1,
8712 to 1,
8713 to 1,
8714 to 1,
8715 to 1,
8716 to 1,
8717 to 1,
8718 to 1,
8719 to 1,
8720 to 1,
8721 to 1,
8722 to 1,
8723 to 1,
8724 to 1,
8725 to 1,
8726 to 1,
8727 to 1,
8728 to 1,
8729 to 1,
8730 to 1,
8731 to 1,
8732 to 1,
8733 to 1,
8734 to 1,
8735 to 1,
8736 to 1,
8737 to 1,
8738 to 1,
8739 to 1,
8740 to 1,
8741 to 1,
8742 to 1,
8743 to 1,
8744 to 1,
8745 to 1,
8746 to 1,
8747 to 1,
8748 to 1,
8749 to 1,
8750 to 1,
8751 to 1,
8752 to 1,
8753 to 1,
8754 to 1,
8755 to 1,
8756 to 1,
8757 to 1,
8758 to 1,
8759 to 1,
8760 to 1,
8761 to 1,
8762 to 1,
8763 to 1,
8764 to 1,
8765 to 1,
8766 to 1,
8767 to 1,
8768 to 1,
8769 to 1,
8770 to 1,
8771 to 1,
8772 to 1,
8773 to 1,
8774 to 1,
8775 to 1,
8776 to 1,
8777 to 1,
8778 to 1,
8779 to 1,
8780 to 1,
8781 to 1,
8782 to 1,
8783 to 1,
8784 to 1,
8785 to 1,
8786 to 1,
8787 to 1,
8788 to 1,
8789 to 1,
8790 to 1,
8791 to 1,
8792 to 1,
8793 to 1,
8794 to 1,
8795 to 1,
8796 to 1,
8797 to 1,
8798 to 1,
8799 to 1,
8800 to 1,
8801 to 1,
8802 to 1,
8803 to 1,
8804 to 1,
8805 to 1,
8806 to 1,
8807 to 1,
8808 to 1,
8809 to 1,
8810 to 1,
8811 to 1,
8812 to 1,
8813 to 1,
8814 to 1,
8815 to 1,
8816 to 1,
8817 to 1,
8818 to 1,
8819 to 1,
8820 to 1,
8821 to 1,
8822 to 1,
8823 to 1,
8824 to 1,
8825 to 1,
8826 to 1,
8827 to 1,
8828 to 1,
8829 to 1,
8830 to 1,
8831 to 1,
8832 to 1,
8833 to 1,
8834 to 1,
8835 to 1,
8836 to 1,
8837 to 1,
8838 to 1,
8839 to 1,
8840 to 1,
8841 to 1,
8842 to 1,
8843 to 1,
8844 to 1,
8845 to 1,
8846 to 1,
8847 to 1,
8848 to 1,
8849 to 1,
8850 to 1,
8851 to 1,
8852 to 1,
8853 to 1,
8854 to 1,
8855 to 1,
8856 to 1,
8857 to 1,
8858 to 1,
8859 to 1,
8860 to 1,
8861 to 1,
8862 to 1,
8863 to 1,
8864 to 1,
8865 to 1,
8866 to 1,
8867 to 1,
8868 to 1,
8869 to 1,
8870 to 1,
8871 to 1,
8872 to 1,
8873 to 1,
8874 to 1,
8875 to 1,
8876 to 1,
8877 to 1,
8878 to 1,
8879 to 1,
8880 to 1,
8881 to 1,
8882 to 1,
8883 to 1,
8884 to 1,
8885 to 1,
8886 to 1,
8887 to 1,
8888 to 1,
8889 to 1,
8890 to 1,
8891 to 1,
8892 to 1,
8893 to 1,
8894 to 1,
8895 to 1,
8896 to 1,
8897 to 1,
8898 to 1,
8899 to 1,
8900 to 1,
8901 to 1,
8902 to 1,
8903 to 1,
8904 to 1,
8905 to 1,
8906 to 1,
8907 to 1,
8908 to 1,
8909 to 1,
8910 to 1,
8911 to 1,
8912 to 1,
8913 to 1,
8914 to 1,
8915 to 1,
8916 to 1,
8917 to 1,
8918 to 1,
8919 to 1,
8920 to 1,
8921 to 1,
8922 to 1,
8923 to 1,
8924 to 1,
8925 to 1,
8926 to 1,
8927 to 1,
8928 to 1,
8929 to 1,
8930 to 1,
8931 to 1,
8932 to 1,
8933 to 1,
8934 to 1,
8935 to 1,
8936 to 1,
8937 to 1,
8938 to 1,
8939 to 1,
8940 to 1,
8941 to 1,
8942 to 1,
8943 to 1,
8944 to 1,
8945 to 1,
8946 to 1,
8947 to 1,
8948 to 1,
8949 to 1,
8950 to 1,
8951 to 1,
8952 to 1,
8953 to 1,
8954 to 1,
8955 to 1,
8956 to 1,
8957 to 1,
8958 to 1,
8959 to 1,
8960 to 1,
8961 to 1,
8962 to 1,
8963 to 1,
8964 to 1,
8965 to 1,
8966 to 1,
8967 to 1,
8968 to 1,
8969 to 1,
8970 to 1,
8971 to 1,
8972 to 1,
8973 to 1,
8974 to 1,
8975 to 1,
8976 to 1,
8977 to 1,
8978 to 1,
8979 to 1,
8980 to 1,
8981 to 1,
8982 to 1,
8983 to 1,
8984 to 1,
8985 to 1,
8986 to 1,
8987 to 1,
8988 to 1,
8989 to 1,
8990 to 1,
8991 to 1,
8992 to 1,
8993 to 1,
8994 to 1,
8995 to 1,
8996 to 1,
8997 to 1,
8998 to 1,
8999 to 1,
9000 to 1,
9001 to 1,
9002 to 1,
9003 to 1,
9004 to 1,
9005 to 1,
9006 to 1,
9007 to 1,
9008 to 1,
9009 to 1,
9010 to 1,
9011 to 1,
9012 to 1,
9013 to 1,
9014 to 1,
9015 to 1,
9016 to 1,
9017 to 1,
9018 to 1,
9019 to 1,
9020 to 1,
9021 to 1,
9022 to 1,
9023 to 1,
9024 to 1,
9025 to 1,
9026 to 1,
9027 to 1,
9028 to 1,
9029 to 1,
9030 to 1,
9031 to 1,
9032 to 1,
9033 to 1,
9034 to 1,
9035 to 1,
9036 to 1,
9037 to 1,
9038 to 1,
9039 to 1,
9040 to 1,
9041 to 1,
9042 to 1,
9043 to 1,
9044 to 1,
9045 to 1,
9046 to 1,
9047 to 1,
9048 to 1,
9049 to 1,
9050 to 1,
9051 to 1,
9052 to 1,
9053 to 1,
9054 to 1,
9055 to 1,
9056 to 1,
9057 to 1,
9058 to 1,
9059 to 1,
9060 to 1,
9061 to 1,
9062 to 1,
9063 to 1,
9064 to 1,
9065 to 1,
9066 to 1,
9067 to 1,
9068 to 1,
9069 to 1,
9070 to 1,
9071 to 1,
9072 to 1,
9073 to 1,
9074 to 1,
9075 to 1,
9076 to 1,
9077 to 1,
9078 to 1,
9079 to 1,
9080 to 1,
9081 to 1,
9082 to 1,
9083 to 1,
9084 to 1,
9085 to 1,
9086 to 1,
9087 to 1,
9088 to 1,
9089 to 1,
9090 to 1,
9091 to 1,
9092 to 1,
9093 to 1,
9094 to 1,
9095 to 1,
9096 to 1,
9097 to 1,
9098 to 1,
9099 to 1,
9100 to 1,
9101 to 1,
9102 to 1,
9103 to 1,
9104 to 1,
9105 to 1,
9106 to 1,
9107 to 1,
9108 to 1,
9109 to 1,
9110 to 1,
9111 to 1,
9112 to 1,
9113 to 1,
9114 to 1,
9115 to 1,
9116 to 1,
9117 to 1,
9118 to 1,
9119 to 1,
9120 to 1,
9121 to 1,
9122 to 1,
9123 to 1,
9124 to 1,
9125 to 1,
9126 to 1,
9127 to 1,
9128 to 1,
9129 to 1,
9130 to 1,
9131 to 1,
9132 to 1,
9133 to 1,
9134 to 1,
9135 to 1,
9136 to 1,
9137 to 1,
9138 to 1,
9139 to 1,
9140 to 1,
9141 to 1,
9142 to 1,
9143 to 1,
9144 to 1,
9145 to 1,
9146 to 1,
9147 to 1,
9148 to 1,
9149 to 1,
9150 to 1,
9151 to 1,
9152 to 1,
9153 to 1,
9154 to 1,
9155 to 1,
9156 to 1,
9157 to 1,
9158 to 1,
9159 to 1,
9160 to 1,
9161 to 1,
9162 to 1,
9163 to 1,
9164 to 1,
9165 to 1,
9166 to 1,
9167 to 1,
9168 to 1,
9169 to 1,
9170 to 1,
9171 to 1,
9172 to 1,
9173 to 1,
9174 to 1,
9175 to 1,
9176 to 1,
9177 to 1,
9178 to 1,
9179 to 1,
9180 to 1,
9181 to 1,
9182 to 1,
9183 to 1,
9184 to 1,
9185 to 1,
9186 to 1,
9187 to 1,
9188 to 1,
9189 to 1,
9190 to 1,
9191 to 1,
9192 to 1,
9193 to 1,
9194 to 1,
9195 to 1,
9196 to 1,
9197 to 1,
9198 to 1,
9199 to 1,
9200 to 1,
9201 to 1,
9202 to 1,
9203 to 1,
9204 to 1,
9205 to 1,
9206 to 1,
9207 to 1,
9208 to 1,
9209 to 1,
9210 to 1,
9211 to 1,
9212 to 1,
9213 to 1,
9214 to 1,
9215 to 1,
9216 to 1,
9217 to 1,
9218 to 1,
9219 to 1,
9220 to 1,
9221 to 1,
9222 to 1,
9223 to 1,
9224 to 1,
9225 to 1,
9226 to 1,
9227 to 1,
9228 to 1,
9229 to 1,
9230 to 1,
9231 to 1,
9232 to 1,
9233 to 1,
9234 to 1,
9235 to 1,
9236 to 1,
9237 to 1,
9238 to 1,
9239 to 1,
9240 to 1,
9241 to 1,
9242 to 1,
9243 to 1,
9244 to 1,
9245 to 1,
9246 to 1,
9247 to 1,
9248 to 1,
9249 to 1,
9250 to 1,
9251 to 1,
9252 to 1,
9253 to 1,
9254 to 1,
9255 to 1,
9256 to 1,
9257 to 1,
9258 to 1,
9259 to 1,
9260 to 1,
9261 to 1,
9262 to 1,
9263 to 1,
9264 to 1,
9265 to 1,
9266 to 1,
9267 to 1,
9268 to 1,
9269 to 1,
9270 to 1,
9271 to 1,
9272 to 1,
9273 to 1,
9274 to 1,
9275 to 1,
9276 to 1,
9277 to 1,
9278 to 1,
9279 to 1,
9280 to 1,
9281 to 1,
9282 to 1,
9283 to 1,
9284 to 1,
9285 to 1,
9286 to 1,
9287 to 1,
9288 to 1,
9289 to 1,
9290 to 1,
9291 to 1,
    )
}