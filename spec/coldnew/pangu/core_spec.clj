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
     (vs "V" "V"))

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
