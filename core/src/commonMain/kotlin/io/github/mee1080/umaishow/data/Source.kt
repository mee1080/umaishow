package io.github.mee1080.umaishow.data

object Source {

    const val chara: String = """
アイネスフウジン:105,201,311,2105,2601,7020,2803,2901,3002,3003,3101,2510,2522,3204,8360,2404,2603,408,518,2716,3501,3507
アグネスタキオン:104,202,314,2001,2107,2601,2814,2903,3003,3101,2505,3204,8219,8220,8221,8222,8223,8224,8225,8226,8227,8228,8229,8230,8231,8232,8233,8234,2407,2604,8450,8486,8518,8543,8647,519,8682,8706,8880,9158,410,2719,2524,3507,9320,9716
アグネスデジタル:102,202,314,2601,2813,2902,3002,3003,3101,3102,2516,2511,2518,2501,3205,8144,8145,8146,8147,8148,8149,8150,8151,8456,8524,8600,8623,8752,8907,8939,8971,9098,9190,2532,2604,417,527,2534,3401,3504,3505,3506,3507,3509,2407,9329,9393,9427,9461,9495,9529,9563,9597,9631,9691
アストンマーチャン:2901,3001,3203,102,2604,202,2602,2704,2815,3101,2513,8659,8719,8739,8797,8838,8839,8840,8841,8842,8843,8845,8846,8847,8848,8849,8850,8851,8852,8853,8854,8855,8856,8858,8859,8861,8862,8863,2409,403,3508,9236,9288,9380,9414,9448,9482,9516,9550,9584,9618,9678,358
アドマイヤベガ:105,202,315,2601,2812,2904,3003,3101,2510,8235,8236,8237,8238,8239,8240,8241,8242,8243,8244,8245,8246,8247,8248,8249,8250,8451,8487,8519,8544,8648,8683,8707,8881,9159,2603,3203,404,538,2524,3501,3507,2407,9321,9717
イクノディクタス:8549,8550,8551,8552,8553,8554,2903,3003,3101,3204,2404,2604,103,202,328,513,2106,2602,2706,2803,8785,8859,9023,9224,415,544,3301,3401,3502,3503,3504,3509,9706
イナリワン:106,201,506,2601,2801,2904,3003,3004,3101,3102,2523,2512,2506,331,2530,2403,2604,3205,405,2726,3401,3503,3504,3505
ウイニングチケット:105,202,316,404,507,2002,2102,2302,2601,7018,7021,2806,2903,3003,3101,2510,3203,8038,8048,8075,8080,8103,8139,8194,8293,8325,8332,8353,8404,2405,2603,8430,8495,8552,8590,8613,8656,8716,8736,8794,8891,8923,8955,9082,9132,9174,523,2710,3501,3504,9233,9285,9377,9411,9445,9479,9513,9547,9581,9615,9675
ウオッカ:102,202,303,403,2602,7012,2705,2815,2903,3002,3003,3101,2510,2516,2521,2511,2519,2508,3204,2409,2604,2009,525,3401,3502,3504,3506,3507,3509,2210
エアグルーヴ:105,202,307,501,2002,2106,2602,7001,2809,2902,3003,3101,2509,2516,3204,8035,8045,8072,8077,8100,8136,8190,8289,8322,8329,8350,8400,2406,2604,8427,8492,8549,8587,8610,8653,8713,8733,8791,8888,8920,8952,9079,9129,9171,404,524,2714,2503,3502,3503,3504,9230,9282,2211,9374,9408,9442,9476,9510,9544,9578,9612,9672,2215
エアシャカール:104,202,317,2001,2601,2813,2904,3003,3101,2505,2515,3202,8251,8252,8253,8254,8255,8256,8257,8258,8259,8260,8261,8262,8263,8264,8265,8266,8452,8488,8520,8545,8649,2603,2407,8684,8708,8882,9160,410,529,3501,3503,3504,3506,9322,9718
エイシンフラッシュ:105,202,318,2601,2701,2817,2903,3003,3101,2510,2516,3203,8267,8268,8269,8270,8271,8272,8273,8274,8458,8526,8602,8625,8754,8909,8941,8973,9100,9192,2603,407,3401,3501,3503,3504,3506,2410,9331,9395,9429,9463,9497,9531,9565,9599,9633,9693
エルコンドルパサー:103,201,305,401,502,2601,7000,7004,2811,2902,3002,3003,3101,2519,2507,3203,8108,8109,8110,8111,8112,8113,8114,8115,2406,2604,8455,8523,8599,8622,8751,8906,8938,8970,9097,9189,524,3506,3509,9328,9392,9426,9460,9494,9528,9562,9596,9630,9690
オグリキャップ:106,202,302,506,2601,7009,7010,7011,2701,2802,2903,3002,3003,3101,2523,2511,2518,3203,8068,8069,8070,8071,8116,8178,8275,8285,8310,8413,8415,8417,2403,2603,8436,8472,8503,8529,8633,8865,405,523,545,3504,3505,3509,9298
カツラギエース:2901,329,3101,202,406,548,2825,2512,2519,2503,3501,3503,3504,2402,2603,106,2601,3003,3204,9230,9231,9232,9233,9234,9235,9236,9237,9238,9239,9240,9241,9242,9243,9244,9245,9246,9247,9248,9249,9250,9251,9252,9253,9254,9255,9256
カレンチャン:102,202,315,2602,2817,2902,3001,3101,2502,2513,8008,8024,8059,8089,8125,8155,8169,8195,8210,8226,8242,8258,8275,8276,8294,8341,8361,8387,8405,8560,8805,9036,9061,2603,3203,416,543,2713,3506,3508,2410,9244,9264,9301,9653
カワカミプリンセス:103,202,319,2602,2903,3002,3003,3101,2509,2514,8277,8278,8279,8280,8281,8282,8283,8284,8362,8605,8628,8689,8726,8759,8914,8946,8978,9105,9165,9197,2604,413,546,3502,3206,2409,9402,9436,9470,9504,9538,9572,9606,9640,9700,9725
キタサンブラック:8466,8502,8581,8587,8588,8589,8590,8591,8592,8593,8594,8596,8597,8598,8599,8600,8601,8602,8603,8604,8605,8606,8607,2901,3003,3004,3101,2523,2506,2516,2515,2519,3203,2604,101,202,332,515,517,2203,2601,7029,2703,8667,8770,8824,8843,8989,9007,9116,9143,9208,420,519,2828,2503,3501,3503,3504,2412,9341,9360
キングヘイロー:103,202,322,401,504,2601,7007,7023,7024,2811,2903,3001,3101,2502,3204,8371,8419,8420,8421,8422,8423,8424,8425,8426,2406,2604,8607,8630,8691,8728,8761,8916,8948,8980,9107,9167,9199,541,3501,3504,3508,3509,9404,9438,9472,9506,9540,9574,9608,9642,9702,9727
グラスワンダー:103,201,305,401,502,2103,2601,7003,7013,7023,2811,2903,3002,3003,3101,2523,2512,2522,3202,2406,2604,524,536,3507,3509
ケイエスミラクル:3001,3203,339,2804,105,202,2601,3101,8757,8912,8944,8976,8984,8985,8986,8987,8988,8989,8994,8995,8996,8997,8998,8999,9000,9001,2404,2902,408,521,2709,3301,3508,2604,9334,9398,9432,9466,9500,9534,9568,9602,9636,9696
コパノリッキー:2901,3203,103,7031,7032,2604,202,2010,2101,2601,3002,3003,3102,2530,2525,2501,2529,8672,8775,8829,8848,8994,9012,9079,9080,9081,9082,9083,9087,9088,9089,9090,9091,9092,9093,9094,9096,9097,9098,9099,9100,9101,9102,9104,9105,9106,9107,9108,9109,341,2532,2533,413,520,2711,3401,3505,3509,2411,9346,9365
ゴールドシチー:104,202,320,2105,2601,2801,2902,3002,3101,3204,8009,8025,8060,8090,8126,8156,8170,8196,8211,8227,8243,8259,8285,8286,8295,8342,8363,8388,8406,8561,2521,8806,9037,9062,412,3501,3503,3507,2706,2403,2603,9245,9265,9302,9654
ゴールドシップ:105,202,2101,2303,2601,7016,2904,3003,3004,3101,2523,2512,2506,2505,2515,3203,8033,8043,8072,8073,8074,8075,8076,8098,8109,8134,8145,8181,8268,8278,8303,8313,8320,8373,8420,2603,8432,8461,8497,8576,8662,8765,8819,8838,8984,9002,9111,9138,9203,407,523,525,528,2827,3401,3501,3503,3504,3506,9336,9355
サイレンススズカ:104,202,301,402,2001,2601,7000,7001,7002,7013,7015,2810,2901,3003,3101,2512,3205,8017,8018,8019,8020,8021,8022,8023,8024,8025,8026,8027,8028,8029,8030,8031,8032,2406,2603,8444,8480,8512,8537,8641,518,8676,8700,8874,9152,523,525,526,2724,3506,3509,9314,9710
サウンズオブアース:202,2601,8673,8776,8830,8849,8995,9013,9122,9149,9171,9172,9173,9174,9175,9179,9180,9181,9182,9183,9184,9185,9186,9189,9190,9191,9192,9193,9194,9197,9198,9199,9200,9201,2903,417,2718,3301,3401,3501,3504,3506,2209,2412,9347,9366,3101,3204,2603,102,357,3004
サクラチヨノオー:104,201,324,511,512,2202,7025,7026,2802,2902,3002,3003,2510,2522,3202,8427,8428,8429,8430,8431,8432,8433,8434,8435,8436,8437,8438,8439,8440,8441,8442,8443,8444,8445,8446,8447,8448,8449,8450,8451,8452,8453,8454,8455,8456,8457,8458,8459,8460,2403,2604,8557,8594,8617,3101,2601,8697,8744,8779,8802,8852,8899,8931,8963,9000,9016,9033,9058,9090,9127,9182,9217,411,3501,3507,3509,9241,9261,9296,9352,9371,9385,9419,9453,9487,9521,9555,9589,9623,9650,9683
サクラバクシンオー:104,201,2003,2106,2601,2805,2902,3001,3101,2513,3204,8287,8288,8289,8290,8291,8292,8293,8294,8295,8296,8297,8298,8299,8300,8301,509,2404,2603,511,8441,8476,8508,8533,8570,8574,8637,2203,8788,8862,8869,9026,9227,411,2720,3508
サクラローレル:511,2903,3004,3101,2506,3205,105,201,337,2601,2807,2523,8695,8696,8697,8698,8699,8700,8701,8702,8703,8704,8705,8706,8707,8708,8709,8710,8711,8712,407,3504,3506,2405,2603,9281,9670
サトノクラウン:2512,101,201,2111,2601,2703,8810,8865,8866,8867,8868,8869,8870,8872,8873,8874,8875,8876,8877,8878,8879,8880,8881,8882,8883,8884,8885,8886,8887,2903,349,418,504,522,2828,3401,3501,3503,3504,3506,2604,9249,9269,9306,3003,3101,3203,2412,9658
サトノダイヤモンド:8465,8501,8580,8610,8611,8612,8613,8614,8615,8616,8617,8619,8620,8621,8622,8623,8624,8625,8626,8627,8628,8629,8630,2903,3004,3101,2523,2515,3201,2603,101,202,332,515,516,2601,7029,2824,8666,8769,8823,8842,8988,9006,9115,9142,9207,420,504,519,522,3501,3503,3504,3506,2412,9340,9359
シュヴァルグラン:3203,101,202,2002,2101,2601,3003,3004,3101,2519,8669,8772,8826,8845,8888,8889,8890,8891,8892,8895,8896,8897,8898,8899,8900,8901,8902,8903,8905,8906,8907,8908,8909,8910,8911,8912,8913,8914,8915,8916,8917,8918,2903,420,2708,2828,3401,3503,3504,3506,2603,2412,9343,9362,355
シリウスシンボリ:8461,8462,8463,8464,8465,8466,8467,8468,8469,8470,8471,2902,3003,3101,2510,3203,2402,2604,106,201,325,2601,2818,8692,8729,8762,8917,8949,8981,9108,9168,9200,406,2712,3401,3506,3509,9405,9439,9473,9507,9541,9575,9609,9643,9703,9728
シンコウウインディ:105,201,2601,2809,2902,3002,3102,2501,8010,8026,8061,8091,8127,8157,8171,8197,8212,8228,8244,8260,8296,8310,8311,8343,8364,8389,8407,8562,3204,8807,9038,9063,2406,347,2603,404,2720,3505,3509,9246,9266,9303,9655
シンボリクリスエス:2903,2516,3201,201,105,2103,2207,2601,3003,3101,2523,2408,345,409,2822,3504,2604
シンボリルドルフ:106,201,501,2201,2601,2702,2902,3003,3004,3101,2523,2510,2506,2505,2515,2519,3203,8005,8021,8056,8086,8122,8134,8135,8136,8137,8138,8139,8140,8141,8142,8143,8166,8207,8223,8239,8255,8281,8338,8376,8384,8423,2402,2604,8470,8585,8598,8621,2206,8748,8783,8834,8856,8903,8935,8967,9020,9049,9074,9094,9186,9221,406,524,3501,3503,3504,3506,9277,9389,9423,9457,9491,9525,9559,9593,9627,9666,9687
シーキングザパール:106,202,319,2602,2810,2903,3001,3002,3101,2507,3204,8302,8303,8304,8305,8306,8307,8308,8309,8459,8527,8603,8626,2604,2706,8755,8910,8942,8974,9101,9193,2406,3506,3508,3509,9332,9396,9430,9464,9498,9532,9566,9600,9634,9694,422
ジャングルポケット:2904,2510,3205,340,104,202,2002,2208,2601,2814,3003,3101,2519,8660,8720,8740,8798,8895,8927,8959,9002,9003,9004,9005,9006,9007,9012,9013,9014,9015,9016,9017,9018,9019,9020,9022,9023,9025,9026,9027,2407,410,2726,3501,3504,9237,9289,9381,9415,9449,9483,9517,9551,9585,9619,9679,2604
スイープトウショウ:101,202,2602,2904,3003,3101,2512,2514,2517,8312,8313,8314,8315,8316,8317,8318,8319,8460,8528,8604,8627,2603,335,519,2408,8756,8911,8943,8975,9102,9194,3205,419,3401,3502,3504,3509,9333,9397,9431,9465,9499,9533,9567,9601,9635,9695
スペシャルウィーク:103,202,301,401,502,2001,2102,2301,2601,7003,7004,7005,7006,7007,2811,2903,3003,3004,3101,2510,2506,2516,2519,3205,8001,8002,8003,8004,8005,8006,8007,8008,8009,8010,8011,8012,8013,8014,8015,8016,2406,2603,510,8443,8479,8511,8536,8640,8675,8699,8873,9151,523,525,2725,3501,3503,3504,2212,9313,9709,2213
スマートファルコン:105,202,318,2101,2601,2705,2901,3002,3003,3102,2530,2525,2531,2529,3204,8039,8049,8104,8113,8140,8149,8185,8272,8282,8307,8317,8326,8329,8330,8331,8332,8333,8377,8424,8434,8463,8499,8578,518,2010,8664,8767,8821,8840,8986,9004,9113,9140,9205,407,520,530,2826,3401,3505,3506,3508,3509,2409,2604,9338,9357
スーパークリーク:106,202,321,506,2601,7011,7017,2802,2902,3003,3004,3101,2506,2516,2515,3205,8011,8027,8062,8070,8092,8112,8128,8148,8158,8172,8184,8198,8213,8229,8245,8261,8271,8297,8306,8316,8320,8321,8322,8323,8324,8325,8326,8327,8328,8344,8356,8390,8397,8408,2403,2603,8556,8593,8616,8696,8743,8778,8801,8851,8898,8930,8962,8999,9015,9032,9057,9089,9126,9181,9216,405,2727,2503,3503,3504,9240,9260,9295,9351,9370,9384,9418,9452,9486,9520,9554,9588,9622,9649,9682
セイウンスカイ:103,201,401,502,2601,7006,7024,2811,2901,3003,3004,3101,2505,2515,3204,8152,8153,8154,8155,8156,8157,8158,8159,8160,8161,8438,8474,8505,8531,8635,337,8725,8867,2603,535,2723,3501,3504,2406
ゼンノロブロイ:102,201,313,2601,2902,3003,3101,2523,2516,2519,8334,8335,8336,8337,8338,8339,8340,8341,8342,8343,8344,8345,8346,8347,8348,8349,8453,8489,8521,8546,8650,2603,2001,8685,8709,8883,9161,2408,3203,2701,417,550,2823,3501,3503,3504,3506,9323,9719
タイキシャトル:104,201,304,402,2601,2810,2902,3001,3002,3101,2511,2518,2513,3203,8082,8083,8084,8085,8086,8087,8088,8089,8090,8091,8092,8093,8094,8095,8096,8097,2406,2604,8446,8482,8514,8539,8643,8678,8702,8876,9154,524,534,3506,3508,3509,9316,9712
タップダンスシチー:330,2901,202,410,2709,2813,2512,2519,3401,3504,3506,2407,2601,9292,9293,9294,9295,9296,9297,9298,9299,9300,9301,9302,9303,9304,9305,9306,9307,9308,9309,9310,9311,9312,9313,9314,9315,9316,9317,9318,9319,9320,9321,9322,9323,9324,9325,9326,9327,9328,9329,9330,9331,9332,9333,9334,9335,104,3003,3101,2603,3203,9354,9373,9671
タニノギムレット:2904,2510,3205,338,105,202,2009,3003,3101,2408,409,2822,3501,3509,2603,2210,2601
タマモクロス:106,202,302,506,2601,7009,7017,2801,2904,3003,3004,3101,2512,2506,2516,3205,8036,8046,8073,8078,8101,8137,8191,8290,8323,8330,8351,8401,8428,8493,8550,8588,8611,2403,8654,8714,8734,8792,8889,8921,8953,9080,9130,9172,2604,405,551,3503,3504,9231,9283,9375,9409,9443,9477,9511,9545,9579,9613,9673
ダイイチルビー:3001,3002,2404,104,339,2602,2803,202,2008,2110,3101,2511,2513,3204,8790,8791,8792,8793,8794,8795,8797,8798,8799,8800,8801,8802,8803,8804,8805,8806,8807,8808,8809,8810,8811,8812,8813,8814,8815,8816,8817,2903,412,504,521,2721,3508,3509,2604
ダイタクヘリオス:8572,8573,8574,8575,3002,3101,2518,3204,2404,2604,105,202,330,514,2108,2601,2803,8817,2902,408,521,526,2716,3504,3508,3509,9256
ダイワスカーレット:102,202,303,403,2101,2106,2602,7012,2815,2902,3002,3003,3101,2523,2514,2504,2517,3205,8034,8044,8077,8078,8079,8080,8081,8099,8110,8135,8146,8182,8269,8279,8304,8314,8321,8374,8421,2409,2604,8433,8462,8498,8577,8663,8766,8820,8839,8985,9003,9112,9139,9204,525,2503,3502,3504,3509,9337,9356
ツインターボ:8576,8577,8578,8579,8580,8581,8582,8583,8584,8585,8586,2901,3003,3101,3204,2404,2603,102,201,331,513,2601,7028,2804,2110,8693,8730,8763,8918,8950,8982,9109,9169,9201,403,526,2719,3301,3401,3504,3505,9406,9440,9474,9508,9542,9576,9610,9644,9704,9729
テイエムオペラオー:103,202,306,2104,2601,7005,2702,2812,2902,3003,3004,3101,2523,2512,2506,2516,2505,2519,3203,8004,8020,8055,8085,8116,8117,8121,8153,8165,8189,8206,8222,8238,8254,8288,8337,8358,8383,8399,8559,8804,9035,9060,2603,414,524,537,3501,3503,3504,2407,9243,9263,9300,9652
トウカイテイオー:102,202,308,403,2201,2601,7008,7022,2804,2902,3003,3101,2523,2510,2505,2519,3204,8001,8017,8033,8034,8035,8036,8037,8038,8039,8040,8041,8042,8052,8082,8118,8162,8203,8219,8235,8251,8277,8334,8372,8380,8419,2404,2604,8468,8583,8596,8619,517,7028,2007,8746,8781,8832,8854,8901,8933,8965,9018,9047,9072,9092,9184,9219,525,2503,3501,3503,3504,9275,9387,9421,9455,9489,9523,9557,9591,9625,9664,9685
トランセンド:2901,202,2002,2601,2816,3102,3203,8732,343,2501,2520,3505,3506,3509,2729,105,409,2410,2604,3002
トーセンジョーダン:104,202,316,2601,2816,2902,3003,3101,2516,8040,8050,8076,8081,8105,8141,8199,8298,8327,8333,8354,8409,8431,8496,8553,8591,8614,3202,2106,2208,8657,8717,8737,8795,8892,8924,8956,9083,9133,9175,412,3401,3503,3504,2410,2604,9234,9286,2728,9378,9412,9446,9480,9514,9548,9582,9616,9676
ドゥラメンテ:2904,103,201,349,413,2828,2510,3501,3506,2211,2601,3003,3101,2505,3203,3509,2412,2604,9336,9337,9338,9339,9340,9341,9342,9343,9344,9345,9346,9347,9348,9349,9350,9351,9352,9353,9354,9400,9434,9468,9502,9536,9570,9604,9638,9698,2734
ナイスネイチャ:103,202,323,2601,7022,2706,2804,2903,3003,3004,3101,3204,8016,8032,8067,8097,8133,8161,8177,8202,8218,8234,8250,8266,8301,8349,8370,8395,8412,8417,8418,2404,2603,8564,513,8809,9040,9065,415,533,3301,3401,3503,3504,9248,9268,9305,9657
ナカヤマフェスタ:104,201,2601,2816,2903,3003,3101,2512,8041,8051,8106,8114,8142,8150,8186,8273,8283,8308,8318,8328,8350,8351,8352,8353,8354,8378,8425,8435,8464,8500,8579,325,2604,2101,3204,8665,8768,8822,8841,8987,9005,9114,9141,9206,2410,412,3501,3506,9339,9358
ナリタタイシン:105,202,321,404,507,2601,7019,7021,2806,2904,3003,3101,2505,3206,8042,8107,8117,8143,8179,8276,8284,8286,8311,8355,8356,8365,8379,8414,8416,8418,8426,8437,8467,8473,8504,8530,8554,8572,8582,8634,8674,8722,8831,8866,9150,2524,3501,3503,3507,2405,2603,9291,9299
ナリタトップロード:2902,3003,2515,3204,105,202,340,2407,2109,2601,2705,2812,3004,3101,8713,8714,8715,8716,8717,8718,8719,8720,8721,8722,404,3401,3501,3504,2604,2011,9707
ナリタブライアン:105,202,501,2601,2807,2903,3003,3004,3101,2523,2510,2522,2505,2515,3205,8118,8119,8120,8121,8122,8123,8124,8125,8126,8127,8128,8129,8130,8131,8132,8133,8447,8483,8515,8540,8644,338,2009,8679,8703,8877,9155,2604,407,523,524,3501,3504,3507,3509,2405,9317,9713
ニシノフラワー:101,202,310,2602,2805,2902,3001,3002,3101,2504,2521,2513,8357,8358,8359,8360,8361,8362,8363,8364,8365,8366,8367,8368,8369,8370,8371,8471,8491,8548,8586,8652,2404,2604,8732,8837,8887,419,2722,3502,3507,3508,3509,3204,9731
ネオユニヴァース:2510,2505,2903,3101,202,348,410,2823,2503,3501,3503,2408,2603,104,2001,2209,2601,3003,3205,9257,9258,9259,9260,9261,9262,9263,9264,9265,9266,9267,9268,9269,9270,9271,9272,9273,9274,9275,9276,9277,9278,9279,9280,9281,9327,9723
ノースフライト:2902,3002,2518,2602,202,2002,2806,3101,2511,3204,8658,8718,8738,8765,8766,8767,8768,8769,8770,8772,8773,8774,8775,8776,8777,8778,8779,8780,8781,8782,8783,8785,8785,8787,8788,8789,8790,2718,3509,2405,9235,9287,9379,9413,9447,9481,9515,9549,9583,9617,9677,104,358,411,2604
ハルウララ:103,202,322,2602,2812,2904,3001,3102,3202,8366,8372,8373,8374,8375,8376,8377,8378,8379,508,509,2407,2603,510,8606,8629,8690,8727,8760,8915,8947,8979,9106,9166,9198,414,527,528,529,530,531,532,533,534,535,536,537,538,539,540,541,542,543,544,545,546,547,548,549,550,551,2707,3301,3401,3505,3508,9403,9437,9471,9505,9539,9573,9607,9641,9701,9726
バンブーメモリー:105,202,320,2601,2802,2903,3001,3002,3101,2511,2513,8367,2604,2403,409,3401,3504,3508,3509,3205,2730
ヒシアケボノ:103,202,312,2601,2808,2902,3001,3101,2513,8180,8181,8182,8183,8184,8185,8186,8187,512,8457,8525,8601,8624,3202,8753,8908,8940,8972,9099,9191,2603,413,2707,3505,3508,2405,9330,9394,9428,9462,9496,9530,9564,9598,9632,9692
ヒシアマゾン:105,201,505,2602,7014,7015,2807,2904,3003,3101,2521,2517,3203,8357,2603,407,524,2712,3504,3507,3509,2405
ヒシミラクル:2903,202,346,409,549,2713,2822,2512,2506,2515,3401,3503,3504,3203,2604,2408,105,2011,2601,3004,3101,9282,9283,9284,9285,9286,9287,9288,9289,9290,9291,9708
ビコーペガサス:101,202,312,2601,7014,2807,2903,3001,3101,3202,8012,8028,8063,8071,8093,8115,8129,8151,8173,8187,8214,8230,8246,8262,8274,8309,8319,8345,8391,8724,8997,9030,9055,9124,419,3301,3401,3508,3509,2405,9258,9293,9349,9368,9647,2603,2735
ビワハヤヒデ:105,202,306,404,507,2601,7018,7019,2703,2806,2902,3003,3004,3101,2512,2506,2515,3203,8037,8047,8074,8079,8102,8138,8192,8291,8324,8331,8352,8402,8429,8494,8551,8589,8612,8655,8715,8735,8793,8890,8922,8954,9081,9131,9173,2603,3501,3503,3504,2405,9232,9284,9376,9410,9444,9478,9512,9546,9580,9614,9674
ファインモーション:104,202,307,504,2602,2902,3003,3101,2514,2517,3201,8006,8022,8057,8069,8087,8111,8123,8147,8167,8183,8208,8224,8240,8256,8270,8305,8315,8339,8385,2408,8723,8996,9029,9054,9123,2604,402,542,2822,3509,9257,9292,9348,9367,9646
フジキセキ:105,202,505,2001,2601,2808,2902,3002,3101,2522,3204,8052,8053,8054,8055,8056,8057,8058,8059,8060,8061,8062,8063,8064,8065,8066,8067,8445,8481,8513,8538,8642,8677,8701,8875,9153,2604,407,524,2721,3507,3509,2405,9315,9711
ホッコータルマエ:3205,103,7031,202,2601,7033,3002,3003,3102,2525,2531,2529,8758,8913,8945,8977,9104,9111,9112,9113,9114,9115,9116,9122,9123,9124,9125,9126,9127,9128,344,2411,2533,2902,2603,2530,2520,413,520,2827,3401,3505,3506,3509,9335,9399,9433,9467,9501,9535,9569,9603,9637,9697
マチカネタンホイザ:8529,8530,8531,8532,8533,8534,8535,8536,8537,8538,8539,8540,8541,8542,8543,8544,8545,8546,8547,8548,2903,3004,3101,3205,2404,2604,103,202,327,513,2601,2805,8814,9045,9070,415,2726,3301,3401,3501,3503,3504,3509,9253,9273,9310,9662
マチカネフクキタル:104,202,402,2601,7002,2810,2903,3003,3101,2515,3205,8013,8029,8064,8094,8130,8174,8215,8231,8247,8263,8346,8392,8396,8397,2406,2603,8439,8506,327,9052,9077,539,3401,3501,3503,9280,9669
マヤノトップガン:101,202,308,2103,2104,2601,2808,2901,3003,3004,3101,2523,2512,2506,2515,3203,2405,2603,2009,419,531,2711,3503,3504
マルゼンスキー:106,203,2301,2302,2601,2901,3001,3002,3101,2522,3205,8002,8018,8043,8044,8045,8046,8047,8048,8049,8050,8051,8053,8068,8083,8108,8119,8144,8152,8163,8180,8188,8204,8220,8236,8252,8267,8287,8302,8312,8335,8355,8381,8396,8398,2401,2604,2202,8555,8592,8615,2205,8695,8742,8777,8800,8850,8897,8929,8961,8998,9014,9031,9056,9088,9125,9180,9215,406,518,524,3507,3509,9239,9259,9294,9350,9369,9383,9417,9451,9485,9519,9553,9587,9621,9648,9681
マンハッタンカフェ:104,201,309,2001,2601,2704,2814,2903,3004,3101,2523,2506,2515,3203,8162,8163,8164,8165,8166,8167,8168,8169,8170,8171,8172,8173,8174,8175,8176,8177,8448,8484,8516,8541,8645,8680,8704,8878,9156,2603,410,3506,2407,9318,9714
マーベラスサンデー:102,202,323,2601,2808,3003,3101,2512,8380,8381,8382,8383,8384,8385,8386,8387,8388,8389,8390,8391,8392,8393,8394,8395,8454,8490,8522,8547,8651,2001,8686,8710,8884,9162,2903,3205,417,2503,3503,3504,2405,2603,9324,9720
ミスターシービー:205,2601,2904,3003,3101,2510,2516,2505,2515,3204,8398,8399,8400,8401,8402,8403,8404,8405,8406,8407,8408,8409,8410,8411,8412,8442,8477,8509,8534,8571,8575,8638,106,2008,8789,8863,8870,9027,9228,2603,406,2825,3501,3503,3504,3509,2402
ミホノブルボン:104,202,310,2601,2805,2901,3001,3002,3003,3101,2510,2522,2505,3204,2604,411,518,3501,3507,2404
メイショウドトウ:103,202,317,2601,2812,2902,3003,3101,2512,8014,8030,8065,8095,8131,8159,8175,8200,8216,8232,8248,8264,8299,8347,8368,8393,8410,8413,8414,8563,2109,2111,8808,9039,9064,414,540,3503,3504,3203,2407,2603,9247,9267,9304,9656
メジロアルダン:324,7025,7027,2802,8472,8473,8474,8475,8476,8477,8478,8479,8480,8481,8482,8483,8484,8485,8486,8487,8488,8489,8490,8491,2902,3003,3101,3203,2403,2603,106,201,326,2108,2601,503,8813,9044,9069,405,504,3301,3504,9252,9272,9309,9661
メジロドーベル:104,201,304,503,2602,2810,2903,3002,3003,3101,2509,2514,2521,2517,8015,8031,8066,8096,8132,8160,8176,8201,8217,8233,8249,8265,8300,8348,8369,8394,8411,8415,8416,8566,2004,7030,8812,9043,9068,402,532,3502,3503,3507,3509,3205,2406,2604,9251,9271,9308,9660
メジロパーマー:8478,8510,8535,8555,8556,8557,8559,8560,8561,8562,8563,8564,8565,8566,8569,8570,8571,8639,2901,3003,3004,3101,2523,2512,3203,2404,2603,105,202,329,514,2601,2803,503,8816,8872,408,526,2710,3401,3503,3504,9255,9312
メジロブライト:8633,8634,8635,8636,8637,8638,8639,8640,8641,8642,8643,8644,8645,8646,8647,8648,8649,8650,8651,8652,2903,3004,3101,2506,3204,2406,2603,104,202,333,2004,2204,2205,2601,7030,2810,503,8815,9046,9071,402,2722,2524,3401,3501,3503,3504,3507,9254,9274,9311,9663
メジロマックイーン:102,202,403,503,504,2303,2601,7008,7016,2803,2902,3003,3004,3101,2512,2506,2515,3204,8003,8019,8054,8084,8098,8099,8100,8101,8102,8103,8104,8105,8106,8107,8120,8164,8205,8221,8237,8253,8280,8336,8375,8382,8422,2404,2603,8469,8584,8597,8620,328,516,8747,8782,8833,8855,8902,8934,8966,9019,9048,9073,9093,9185,9220,523,525,2503,3503,3504,9276,9388,9422,9456,9490,9524,9558,9592,9626,9665,9686,2214,2216
メジロライアン:105,201,311,503,2601,7010,7020,2803,2903,3003,3101,2512,3204,8007,8023,8058,8088,8124,8154,8168,8178,8179,8193,8209,8225,8241,8257,8292,8340,8359,8386,8403,2404,2603,8565,2204,8811,9042,9067,408,2717,3501,3503,9250,9270,9307,9659
メジロラモーヌ:2902,3002,106,201,2602,503,3003,3101,2509,2504,2517,3204,8694,8731,8764,8819,8820,8821,8822,8823,8824,8826,8827,8828,8829,8830,8831,8832,8833,8834,8836,8837,345,406,504,2715,3502,3509,2403,2603,9407,9441,9475,9509,9543,9577,9611,9645,9705,9730
ヤエノムテキ:7026,7027,2802,8492,8493,8494,8495,8496,8497,8498,8499,8500,8501,8502,8503,8504,8505,8506,8507,8508,8509,8510,8511,8512,8513,8514,8515,8516,8517,8518,8519,8520,8521,8522,8523,8524,8525,8526,8527,8528,2902,3003,3101,2516,2505,3204,2403,2604,105,202,334,2601,8698,8745,8780,8803,8853,8900,8932,8964,9001,9017,9034,9059,9091,9128,9183,9218,409,2717,2503,3501,3503,3504,9242,9262,9297,9353,9372,9386,9420,9454,9488,9522,9556,9590,9624,9651,9684
ヤマニンゼファー:2902,3001,3002,3205,102,201,2804,2604,2601,8723,8724,8725,8726,8727,8728,8729,8730,8731,342,3101,2516,2511,2404,416,521,2727,3508,3509
ユキノビジン:102,201,309,2003,2107,2602,2703,2806,2902,3002,3003,3101,3203,8188,8189,8190,8191,8192,8193,8194,8195,8196,8197,8198,8199,8200,8201,8202,8440,8475,8507,8532,8569,8573,8636,2603,8787,8861,8868,9025,9226,2405,416,3301,3502,3505
ライスシャワー:104,201,313,2601,2704,2805,2902,3003,3004,3101,2506,2515,3203,8203,8204,8205,8206,8207,8208,8209,8210,8211,8212,8213,8214,8215,8216,8217,8218,508,2404,2604,8449,8485,8517,8542,8646,8681,8705,8879,9157,411,523,3401,3501,3503,3504,9319,9715
ラインクラフト:102,2602,2902,350,202,2705,2829,3001,3002,3101,2504,2507,3204,3502,3508,3509,2409,2604,9355,9356,9357,9358,9359,9360,9361,9362,9363,9364,9365,9366,9367,9368,9369,9370,9371,9372,9373,9401,9435,9469,9503,9537,9571,9605,9639,9699,421
ワンダーアキュート:2603,7032,104,2601,7033,2816,3002,3003,3102,2525,2529,3203,2410,343,2533,2902,202,412,520,547,2708,3401,3505,3509
ヴィブロス:2824,101,202,2602,3003,3101,2514,8671,8774,8828,8847,8952,8953,8954,8955,8956,8959,8960,8961,8962,8963,8964,8965,8966,8967,8969,8970,8971,8972,8973,8974,8975,8976,8977,8978,8979,8980,8981,8982,2903,351,418,2715,3401,3506,3509,9345,9364,2412,2604,3204
ヴィルシーナ:9344
    """

    const val relation: String = """
101:2
102:2
103:2
104:2
105:2
106:2
107:2
201:2
202:2
203:2
204:2
205:2
301:2
302:2
303:2
304:2
305:2
306:2
307:2
308:2
309:2
310:2
311:2
312:2
313:2
314:2
315:2
316:2
317:2
318:2
319:2
320:2
321:2
322:2
323:2
324:2
325:2
326:2
327:2
328:2
329:2
330:2
331:2
332:2
333:2
334:2
335:2
336:2
337:2
338:2
339:2
340:2
341:2
342:2
343:2
344:2
345:2
346:2
347:2
348:2
349:2
350:2
351:2
352:2
353:2
354:2
355:2
356:2
357:2
358:2
359:2
360:2
361:2
362:2
363:2
364:2
365:2
366:2
367:2
368:2
369:2
370:2
371:2
372:2
373:2
374:2
375:2
376:2
377:2
378:2
379:2
380:2
381:2
382:2
383:2
384:2
385:2
386:2
387:2
388:2
401:2
402:2
403:2
404:2
405:2
406:2
407:2
408:2
409:2
410:2
411:2
412:2
413:2
414:2
415:2
416:2
417:2
418:2
419:2
420:2
421:2
422:2
501:2
502:2
503:2
504:2
505:2
506:2
507:2
508:8
509:8
510:8
511:2
512:2
513:2
514:2
515:2
516:2
517:2
518:2
519:2
520:2
521:2
522:2
523:2
524:2
525:2
526:2
527:8
528:8
529:8
530:8
531:8
532:8
533:8
534:8
535:8
536:8
537:8
538:8
539:8
540:8
541:8
542:8
543:8
544:8
545:8
546:8
547:8
548:8
549:8
550:8
551:8
2901:7
2902:7
2903:7
2904:7
3001:7
3002:7
3003:7
3004:7
3101:7
3102:7
3505:2
3506:2
3508:2
    """
}