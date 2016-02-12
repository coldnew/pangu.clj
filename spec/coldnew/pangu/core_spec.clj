(ns coldnew.pangu.core-spec
  (:require [speclj.core :refer :all]
            [speclj.run.standard]
            [coldnew.pangu.core :refer :all]))

;; helper function
(defn- verify [str1 str2]
  (should (= str1 str2)))

(defn- vs [str1 str2]
  (verify (spacing str1) str2))

(describe
 "Test spacing()"

 (it "All"
     (vs "新八的構造成分有95%是眼鏡、3%是水、2%是垃圾" "新八的構造成分有 95% 是眼鏡、3% 是水、2% 是垃圾")
     (vs "所以,請問Jackey的鼻子有幾個?3.14個!" "所以, 請問 Jackey 的鼻子有幾個? 3.14 個!")
     (vs "JUST WE就是JUST WE，既不偉大也不卑微！" "JUST WE 就是 JUST WE，既不偉大也不卑微！")
     (vs "搭載MP3播放器，連續播放時數最長達到124小時的超強利刃……菊一文字RX-7!" "搭載 MP3 播放器，連續播放時數最長達到 124 小時的超強利刃…… 菊一文字 RX-7!")
     (vs "Mr.龍島主道：「Let's Party!各位高明博雅君子！」" "Mr. 龍島主道：「Let's Party! 各位高明博雅君子！」"))

 (it "Latin1 Supplement"
     (vs "中文Ø漢字" "中文 Ø 漢字")
     (vs "中文 Ø 漢字" "中文 Ø 漢字"))

 (it "General Punctuation"
     (vs "中文•漢字" "中文 • 漢字")
     (vs "中文 • 漢字" "中文 • 漢字"))

 (it "Number Forms"
     (vs "中文Ⅶ漢字" "中文 Ⅶ 漢字")
     (vs "中文 Ⅶ 漢字" "中文 Ⅶ 漢字"))

 (it "CJK Radicals Supplement"
     (vs "abc⻤123" "abc ⻤ 123")
     (vs "abc ⻤ 123" "abc ⻤ 123"))

 (it "Kangxi Radicals"
     (vs "abc⾗123" "abc ⾗ 123")
     (vs "abc ⾗ 123" "abc ⾗ 123"))

 (it "Hiragana"
     (vs "abcあ123" "abc あ 123")
     (vs "abc あ 123" "abc あ 123"))

 (it "Katakana"
     (vs "abcア123" "abc ア 123")
     (vs "abc ア 123" "abc ア 123"))

 (it "Bopomofo"
     (vs "abcㄅ123" "abc ㄅ 123")
     (vs "abc ㄅ 123" "abc ㄅ 123"))

 (it "Enclosed cjk letters an months"
     (vs "abc㈱123" "abc ㈱ 123")
     (vs "abc ㈱ 123" "abc ㈱ 123"))

 (it "Unified Ideographs"
     (vs "abc丁123" "abc 丁 123")
     (vs "abc 丁 123" "abc 丁 123")
     ;; extra
     (vs "abc㐂123" "abc 㐂 123")
     (vs "abc 㐂 123" "abc 㐂 123"))

 (it "Compatibility Ideographs"
     (vs "abc車123" "abc 車 123")
     (vs "abc 車 123" "abc 車 123"))

 (it "Tilde"
     (vs "前面~後面" "前面~ 後面")
     (vs "前面 ~ 後面" "前面 ~ 後面")
     (vs "前面~ 後面" "前面~ 後面"))

 (it "Back Quote"
     (vs "前面`後面" "前面 ` 後面")
     (vs "前面 ` 後面" "前面 ` 後面")
     (vs "前面` 後面" "前面 ` 後面"))

 (it "Exclamation Mark"
     (vs "前面!後面" "前面! 後面")
     (vs "前面 ! 後面" "前面 ! 後面")
     (vs "前面! 後面" "前面! 後面"))

 (it "At"
     ;; https://twitter.com/vinta
     (vs "前面@vinta後面" "前面 @vinta 後面")
     (vs "前面 @vinta 後面" "前面 @vinta 後面")
     ;; http://weibo.com/vintalines
     (vs "前面@陳上進 後面" "前面 @陳上進 後面")
     (vs "前面 @陳上進 後面" "前面 @陳上進 後面")
     (vs "前面 @陳上進tail" "前面 @陳上進 tail"))

 (it "Hash"
     (vs "前面#H2G2後面" "前面 #H2G2 後面")
     (vs "前面#銀河便車指南 後面" "前面 #銀河便車指南 後面")
     (vs "前面#銀河便車指南tail" "前面 #銀河便車指南 tail")
     (vs "前面#銀河公車指南 #銀河拖吊車指南 後面" "前面 #銀河公車指南 #銀河拖吊車指南 後面")
     (vs "前面#H2G2#後面" "前面 #H2G2# 後面")
     (vs "前面#銀河閃電霹靂車指南#後面" "前面 #銀河閃電霹靂車指南# 後面"))

 (it "dollar"
     (vs "前面$後面" "前面 $ 後面")
     (vs "前面 $ 後面" "前面 $ 後面")
     (vs "前面$100後面" "前面 $100 後面"))

 (it "Percent"
     (vs "前面%後面" "前面 % 後面")
     (vs "前面 % 後面" "前面 % 後面")
     (vs "前面100%後面" "前面 100% 後面"))

 (it "Caret"
     (vs "前面^後面" "前面 ^ 後面")
     (vs "前面 ^ 後面" "前面 ^ 後面"))

 (it "Ampersand"
     (vs "前面&後面" "前面 & 後面")
     (vs "前面 & 後面" "前面 & 後面")
     (vs "Vinta&Mollie" "Vinta&Mollie")
     (vs "Vinta&陳上進" "Vinta & 陳上進")
     (vs "陳上進&Vinta" "陳上進 & Vinta")
     (vs "得到一個A&B的結果" "得到一個 A&B 的結果"))

 (it "Asterisk"
     (vs "前面*後面" "前面 * 後面")
     (vs "前面 * 後面" "前面 * 後面")
     (vs "Vinta*Mollie" "Vinta*Mollie")
     (vs "Vinta*陳上進" "Vinta * 陳上進")
     (vs "陳上進*Vinta" "陳上進 * Vinta")
     (vs "得到一個A*B的結果" "得到一個 A*B 的結果"))


 (it "Parentheses"
     (vs "前面(中文123漢字)後面" "前面 (中文 123 漢字) 後面")
     (vs "前面(中文123)後面" "前面 (中文 123) 後面")
     (vs "前面(123漢字)後面" "前面 (123 漢字) 後面")
     (vs "前面(中文123漢字) tail" "前面 (中文 123 漢字) tail")
     (vs "head (中文123漢字)後面" "head (中文 123 漢字) 後面")
     (vs "head (中文123漢字) tail" "head (中文 123 漢字) tail"))

 (it "Minus"
     (vs "前面-後面" "前面 - 後面")
     (vs "前面 - 後面" "前面 - 後面")
     (vs "Vinta-Mollie" "Vinta-Mollie")
     (vs "Vinta-陳上進" "Vinta - 陳上進")
     (vs "陳上進-Vinta" "陳上進 - Vinta")
     (vs "得到一個A-B的結果" "得到一個 A-B 的結果"))

 (it "Underscore"
     (vs "前面_後面" "前面_後面")
     (vs "前面 _ 後面" "前面 _ 後面"))

 (it "Plus"
     (vs "前面+後面" "前面 + 後面")
     (vs "前面 + 後面" "前面 + 後面")
     (vs "Vinta+Mollie" "Vinta+Mollie")
     (vs "Vinta+陳上進" "Vinta + 陳上進")
     (vs "陳上進+Vinta" "陳上進 + Vinta")
     (vs "得到一個A+B的結果" "得到一個 A+B 的結果")
     (vs "得到一個C++的結果" "得到一個 C++ 的結果"))

 (it "Equal"
     (vs "前面=後面" "前面 = 後面")
     (vs "前面 = 後面" "前面 = 後面")
     (vs "Vinta=Mollie" "Vinta=Mollie")
     (vs "Vinta=陳上進" "Vinta = 陳上進")
     (vs "陳上進=Vinta" "陳上進 = Vinta")
     (vs "得到一個A=B的結果" "得到一個 A=B 的結果"))

 (it "Braces"
     (vs "前面{中文123漢字}後面" "前面 {中文 123 漢字} 後面")
     (vs "前面{中文123}後面" "前面 {中文 123} 後面")
     (vs "前面{123漢字}後面" "前面 {123 漢字} 後面")
     (vs "前面{中文123漢字} tail" "前面 {中文 123 漢字} tail")
     (vs "head {中文123漢字}後面" "head {中文 123 漢字} 後面")
     (vs "head {中文123漢字} tail" "head {中文 123 漢字} tail"))

 (it "Brackets"
     (vs "前面[中文123漢字]後面" "前面 [中文 123 漢字] 後面")
     (vs "前面[中文123]後面" "前面 [中文 123] 後面")
     (vs "前面[123漢字]後面" "前面 [123 漢字] 後面")
     (vs "前面[中文123漢字] tail" "前面 [中文 123 漢字] tail")
     (vs "head [中文123漢字]後面" "head [中文 123 漢字] 後面")
     (vs "head [中文123漢字] tail" "head [中文 123 漢字] tail"))

 (it "Pipe"
     (vs "前面|後面" "前面 | 後面")
     (vs "前面 | 後面" "前面 | 後面")
     (vs "Vinta|Mollie" "Vinta|Mollie")
     (vs "Vinta|陳上進" "Vinta | 陳上進")
     (vs "陳上進|Vinta" "陳上進 | Vinta")
     (vs "得到一個A|B的結果" "得到一個 A|B 的結果"))

 (it "Backslash"
     (vs "前面\\後面" "前面 \\ 後面")
     (vs "前面 \\ 後面" "前面 \\ 後面"))

 (it "Colon"
     (vs "前面:後面" "前面: 後面")
     (vs "前面 : 後面" "前面 : 後面")
     (vs "前面: 後面" "前面: 後面"))

 (it "Semicolon"
     (vs "前面;後面" "前面; 後面")
     (vs "前面 ; 後面" "前面 ; 後面")
     (vs "前面; 後面" "前面; 後面"))

 (it "Quote"
     (vs "前面\"中文123漢字\"後面" "前面 \"中文 123 漢字\" 後面")
     (vs "前面\"123漢字\"後面" "前面 \"123 漢字\" 後面")
     (vs "前面\"中文123漢字 tail" "前面 \"中文 123 漢字 tail")
     (vs "head \"中文123漢字\"後面" "head \"中文 123 漢字\" 後面")
     (vs "head \"中文123漢字\" tail" "head \"中文 123 漢字\" tail"))

 (it "Single Quote"
     (vs "前面 '中文 123 漢字' 後面" "前面'中文123漢字'後面")
     (vs "前面 '中文 123' 後面" "前面'中文123'後面")
     (vs "前面 '123 漢字' 後面" "前面'123漢字'後面")
     (vs "前面 '中文 123 漢字' tail" "前面'中文123漢字' tail")
     (vs "head '中文 123 漢字' 後面" "head '中文123漢字'後面")
     (vs "head '中文 123 漢字' tail" "head '中文123漢字' tail")
     (vs "陳上進 likes 林依諾's status." "陳上進 likes 林依諾's status."))

 (it "Comma"
     (vs "前面,後面" "前面, 後面")
     (vs "前面 , 後面" "前面 , 後面")
     (vs "前面, 後面" "前面, 後面"))

 (it "Less than"
     (vs "前面<後面" "前面 < 後面")
     (vs "前面 < 後面" "前面 < 後面")
     (vs "Vinta<Mollie" "Vinta<Mollie")
     (vs "Vinta<陳上進" "Vinta < 陳上進")
     (vs "陳上進<Vinta" "陳上進 < Vinta")
     (vs "得到一個A<B的結果" "得到一個 A<B 的結果"))

 (it "Greater than"
     (vs "前面>後面" "前面 > 後面")
     (vs "前面 > 後面" "前面 > 後面")
     (vs "Vinta>Mollie" "Vinta>Mollie")
     (vs "Vinta>陳上進" "Vinta > 陳上進")
     (vs "陳上進>Vinta" "陳上進 > Vinta")
     (vs "得到一個A>B的結果" "得到一個 A>B 的結果"))

 (it "Less and Greater than"
     (vs "前面<中文123漢字>後面" "前面 <中文 123 漢字> 後面")
     (vs "前面<中文123>後面" "前面 <中文 123> 後面")
     (vs "前面<123漢字>後面" "前面 <123 漢字> 後面")
     (vs "前面<中文123漢字> tail" "前面 <中文 123 漢字> tail")
     (vs "head <中文123漢字>後面" "head <中文 123 漢字> 後面")
     (vs "head <中文123漢字> tail" "head <中文 123 漢字> tail"))

 (it "Period"
     (vs "前面.後面" "前面. 後面")
     (vs "前面 . 後面" "前面 . 後面")
     (vs "前面. 後面" "前面. 後面"))

 (it "Question Mark"
     (vs "前面?後面" "前面? 後面")
     (vs "前面 ? 後面" "前面 ? 後面")
     (vs "前面? 後面" "前面? 後面"))

 (it "Slash"
     (vs "前面/後面" "前面 / 後面")
     (vs "前面 / 後面" "前面 / 後面")
     (vs "Vinta/Mollie" "Vinta/Mollie")
     (vs "Vinta/陳上進" "Vinta / 陳上進")
     (vs "陳上進/Vinta" "陳上進 / Vinta")
     (vs "得到一個A/B的結果" "得到一個 A/B 的結果"))

 (it "Special characters"
     ;; \u201c and \u201d
     (vs "前面“中文123漢字”後面" "前面 “中文 123 漢字” 後面")
     ;; \u2026
     (vs "前面…後面" "前面… 後面")
     (vs "前面……後面" "前面…… 後面")
     ;; \u2027
     (vs "前面‧後面" "前面 ‧ 後面")))
