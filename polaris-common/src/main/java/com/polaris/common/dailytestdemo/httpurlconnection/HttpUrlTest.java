package com.polaris.common.dailytestdemo.httpurlconnection;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import javafx.scene.web.WebView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUrlTest {

    public static void main(String[] args) throws Exception {
/*        Document doc = Jsoup.connect("https://ebooking.ctrip.com/ebkorderv2/domestic/orderlist.html#tab=3").get();
        System.out.println(doc.title());*/
        //grabXc();
        String text="[{\n" +
                "\t\"merchantRoomName\": null,\n" +
                "\t\"existOrderRemark\": false,\n" +
                "\t\"orderRemark\": null,\n" +
                "\t\"feeCanceled\": null,\n" +
                "\t\"masterOrderId\": null,\n" +
                "\t\"partHotelCount\": null,\n" +
                "\t\"competeState\": null,\n" +
                "\t\"leftSeconds\": null,\n" +
                "\t\"extFormType\": null,\n" +
                "\t\"orderRemarkInfo\": null,\n" +
                "\t\"arrivalAndDeparture\": \"2021-11-28 ~ 2021-11-29\",\n" +
                "\t\"orderStatusDisplay\": \"已入住\",\n" +
                "\t\"allicanceOrder\": false,\n" +
                "\t\"competeOrder\": false,\n" +
                "\t\"buttonListDisplay\": null,\n" +
                "\t\"hotelNameDisplay\": \"\",\n" +
                "\t\"clientNameDisplay\": \"张先\",\n" +
                "\t\"clientNameDomestic\": \"张先\",\n" +
                "\t\"roomNameDisplay\": \"优选大床房<无早>(钟点房)<09:00到17:00,连住3小时>\",\n" +
                "\t\"arrivalAndDepartureDomestic\": \"11/28\",\n" +
                "\t\"isShowConnectGuestCurrentDay\": false,\n" +
                "\t\"orderTypeDisplay\": \"新订\",\n" +
                "\t\"sourceTypeDisplay\": \"EBK\",\n" +
                "\t\"guaranteeTypeDisplay\": null,\n" +
                "\t\"hourRoom\": true,\n" +
                "\t\"showConnectGuestCurrentDay\": false,\n" +
                "\t\"currentOrderStatus\": null,\n" +
                "\t\"buttonList\": null,\n" +
                "\t\"notifyType\": null,\n" +
                "\t\"bedRemarks\": \"\",\n" +
                "\t\"remarks\": null,\n" +
                "\t\"confirmOtherWayType\": null,\n" +
                "\t\"freeRoomOrder\": false,\n" +
                "\t\"childInfo\": null,\n" +
                "\t\"roomTicketOrder\": false,\n" +
                "\t\"cancelTimeOut\": false,\n" +
                "\t\"childPriceOrder\": false,\n" +
                "\t\"orderKey\": \"1543999180\",\n" +
                "\t\"clientName\": \"张先\",\n" +
                "\t\"sourceType\": \"Ebooking\",\n" +
                "\t\"orderID\": \"16881075854\",\n" +
                "\t\"hotel\": 1719461,\n" +
                "\t\"mainLand\": false,\n" +
                "\t\"formID\": 1520979026,\n" +
                "\t\"ctripOrderSourceType\": \"EBK\",\n" +
                "\t\"domestic\": false,\n" +
                "\t\"amount\": \"56.95\",\n" +
                "\t\"autoConfirmed\": null,\n" +
                "\t\"orderStatus\": 100,\n" +
                "\t\"orderType\": \"N\",\n" +
                "\t\"promotionList\": [{\n" +
                "\t\t\t\"sellGapPrice\": \"0.00\",\n" +
                "\t\t\t\"costGapPrice\": \"15.49\",\n" +
                "\t\t\t\"ruleName\": null,\n" +
                "\t\t\t\"remark\": \"按间夜(1天*1间)\",\n" +
                "\t\t\t\"currency\": \"RMB\",\n" +
                "\t\t\t\"name\": \"周末特惠（5-9折）\",\n" +
                "\t\t\t\"Name\": \"周末特惠（5-9折）\",\n" +
                "\t\t\t\"Currency\": \"RMB\",\n" +
                "\t\t\t\"CostGapPrice\": \"15.49\",\n" +
                "\t\t\t\"SellGapPrice\": \"0.00\",\n" +
                "\t\t\t\"RuleName\": null,\n" +
                "\t\t\t\"Remark\": \"按间夜(1天*1间)\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"sellGapPrice\": \"0.00\",\n" +
                "\t\t\t\"costGapPrice\": \"5.00\",\n" +
                "\t\t\t\"ruleName\": null,\n" +
                "\t\t\t\"remark\": \"按间夜(1天*1间)\",\n" +
                "\t\t\t\"currency\": \"RMB\",\n" +
                "\t\t\t\"name\": \"国内部分酒店满减券\",\n" +
                "\t\t\t\"Name\": \"国内部分酒店满减券\",\n" +
                "\t\t\t\"Currency\": \"RMB\",\n" +
                "\t\t\t\"CostGapPrice\": \"5.00\",\n" +
                "\t\t\t\"SellGapPrice\": \"0.00\",\n" +
                "\t\t\t\"RuleName\": null,\n" +
                "\t\t\t\"Remark\": \"按间夜(1天*1间)\"\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"guaranteed\": false,\n" +
                "\t\"showSalePrice\": false,\n" +
                "\t\"showCostPrice\": false,\n" +
                "\t\"riskyOrder\": null,\n" +
                "\t\"con\": null,\n" +
                "\t\"guests\": 1,\n" +
                "\t\"liveDays\": -1,\n" +
                "\t\"token\": \"9513CAE777AD43C5548892373B480C8B\",\n" +
                "\t\"arrival\": \"2021-11-28\",\n" +
                "\t\"departure\": \"2021-11-29\",\n" +
                "\t\"paymentType\": null,\n" +
                "\t\"formDate\": \"2021-11-28 11:51\",\n" +
                "\t\"quantity\": 1,\n" +
                "\t\"roomName\": \"优选大床房<无早>(钟点房)<09:00到17:00,连住3小时>\",\n" +
                "\t\"roomEnName\": \"优选大床房<无早>(钟点房)<09:00到17:00,连住3小时>\",\n" +
                "\t\"hotelName\": null,\n" +
                "\t\"hotelEName\": null,\n" +
                "\t\"totalCostPrice\": \"56.95\",\n" +
                "\t\"totalSalePrice\": \"65.00\",\n" +
                "\t\"showPriceType\": 2,\n" +
                "\t\"urgent\": false,\n" +
                "\t\"riskyType\": null,\n" +
                "\t\"pp\": true,\n" +
                "\t\"allinanceName\": \"ctrip\",\n" +
                "\t\"guaranteeType\": \"\",\n" +
                "\t\"holdRoom\": false,\n" +
                "\t\"freeSale\": false,\n" +
                "\t\"creditOrder\": false,\n" +
                "\t\"orderStatusType\": \"CheckIn\",\n" +
                "\t\"hourRom\": true,\n" +
                "\t\"roomID\": null,\n" +
                "\t\"showGuidedPrice\": false,\n" +
                "\t\"childCount\": 0,\n" +
                "\t\"currency\": \"RMB\",\n" +
                "\t\"OrderID\": \"16881075854\",\n" +
                "\t\"FormID\": 1520979026,\n" +
                "\t\"OrderKey\": \"1543999180\",\n" +
                "\t\"FormDate\": \"2021-11-28 11:51\",\n" +
                "\t\"OrderDate\": null,\n" +
                "\t\"Token\": \"9513CAE777AD43C5548892373B480C8B\",\n" +
                "\t\"SourceType\": \"Ebooking\",\n" +
                "\t\"CtripOrderSourceType\": \"EBK\",\n" +
                "\t\"OrderType\": \"N\",\n" +
                "\t\"OrderStatus\": 100,\n" +
                "\t\"OrderStatusType\": \"CheckIn\",\n" +
                "\t\"RoomName\": \"优选大床房<无早>(钟点房)<09:00到17:00,连住3小时>\",\n" +
                "\t\"RoomEnName\": \"优选大床房<无早>(钟点房)<09:00到17:00,连住3小时>\",\n" +
                "\t\"RoomID\": null,\n" +
                "\t\"Hotel\": 1719461,\n" +
                "\t\"HotelName\": null,\n" +
                "\t\"HotelEName\": null,\n" +
                "\t\"Quantity\": 1,\n" +
                "\t\"Arrival\": \"2021-11-28\",\n" +
                "\t\"Departure\": \"2021-11-29\",\n" +
                "\t\"LiveDays\": -1,\n" +
                "\t\"Guests\": 1,\n" +
                "\t\"Currency\": \"RMB\",\n" +
                "\t\"Amount\": \"56.95\",\n" +
                "\t\"TotalCostPrice\": \"56.95\",\n" +
                "\t\"TotalSalePrice\": \"65.00\",\n" +
                "\t\"IsShowSalePrice\": false,\n" +
                "\t\"IsShowCostPrice\": false,\n" +
                "\t\"ShowGuidedPrice\": false,\n" +
                "\t\"ShowPriceType\": 2,\n" +
                "\t\"PaymentType\": null,\n" +
                "\t\"PromotionList\": [{\n" +
                "\t\t\t\"sellGapPrice\": \"0.00\",\n" +
                "\t\t\t\"costGapPrice\": \"15.49\",\n" +
                "\t\t\t\"ruleName\": null,\n" +
                "\t\t\t\"remark\": \"按间夜(1天*1间)\",\n" +
                "\t\t\t\"currency\": \"RMB\",\n" +
                "\t\t\t\"name\": \"周末特惠（5-9折）\",\n" +
                "\t\t\t\"Name\": \"周末特惠（5-9折）\",\n" +
                "\t\t\t\"Currency\": \"RMB\",\n" +
                "\t\t\t\"CostGapPrice\": \"15.49\",\n" +
                "\t\t\t\"SellGapPrice\": \"0.00\",\n" +
                "\t\t\t\"RuleName\": null,\n" +
                "\t\t\t\"Remark\": \"按间夜(1天*1间)\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"sellGapPrice\": \"0.00\",\n" +
                "\t\t\t\"costGapPrice\": \"5.00\",\n" +
                "\t\t\t\"ruleName\": null,\n" +
                "\t\t\t\"remark\": \"按间夜(1天*1间)\",\n" +
                "\t\t\t\"currency\": \"RMB\",\n" +
                "\t\t\t\"name\": \"国内部分酒店满减券\",\n" +
                "\t\t\t\"Name\": \"国内部分酒店满减券\",\n" +
                "\t\t\t\"Currency\": \"RMB\",\n" +
                "\t\t\t\"CostGapPrice\": \"5.00\",\n" +
                "\t\t\t\"SellGapPrice\": \"0.00\",\n" +
                "\t\t\t\"RuleName\": null,\n" +
                "\t\t\t\"Remark\": \"按间夜(1天*1间)\"\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"ClientName\": \"张先\",\n" +
                "\t\"IsHoldRoom\": false,\n" +
                "\t\"IsUrgent\": false,\n" +
                "\t\"IsFreeSale\": false,\n" +
                "\t\"IsCreditOrder\": false,\n" +
                "\t\"IsGuaranteed\": false,\n" +
                "\t\"GuaranteeType\": \"\",\n" +
                "\t\"IsAutoConfirmed\": null,\n" +
                "\t\"IsCON\": null,\n" +
                "\t\"IsPP\": true,\n" +
                "\t\"IsRiskyOrder\": null,\n" +
                "\t\"RiskyType\": null,\n" +
                "\t\"ChildCount\": 0,\n" +
                "\t\"AllinanceName\": \"ctrip\",\n" +
                "\t\"IsHourRoom\": true,\n" +
                "\t\"HourRoomInfo\": \"12:30-15:30\",\n" +
                "\t\"NotifyType\": null,\n" +
                "\t\"BedRemarks\": \"\",\n" +
                "\t\"Remarks\": null,\n" +
                "\t\"ConfirmOtherWayType\": null,\n" +
                "\t\"CurrentOrderStatus\": null,\n" +
                "\t\"RightsVMInfo\": null,\n" +
                "\t\"IsRoomTicketOrder\": false,\n" +
                "\t\"ComplainStatus\": null,\n" +
                "\t\"OrderFaqStatus\": null,\n" +
                "\t\"IsAllicanceOrder\": false,\n" +
                "\t\"HourStartTime\": \"2021-11-28 12:30:00\",\n" +
                "\t\"HourEndTime\": \"2021-11-28 15:30:00\",\n" +
                "\t\"IsCancelTimeOut\": false,\n" +
                "\t\"isCompeteOrder\": false,\n" +
                "\t\"IsChildPriceOrder\": false,\n" +
                "\t\"GuestInputPersonCountDesc\": null,\n" +
                "\t\"SourceTypeDisplay\": \"EBK\",\n" +
                "\t\"OrderTypeDisplay\": \"新订\",\n" +
                "\t\"OrderStatusDisplay\": \"已入住\",\n" +
                "\t\"RoomNameDisplay\": \"优选大床房<无早>(钟点房)<09:00到17:00,连住3小时>\",\n" +
                "\t\"ArrivalAndDeparture\": \"2021-11-28 ~ 2021-11-29\",\n" +
                "\t\"ClientNameDisplay\": \"张先\",\n" +
                "\t\"GuaranteeTypeDisplay\": null,\n" +
                "\t\"ButtonListDisplay\": null,\n" +
                "\t\"IsShowConnectGuestCurrentDay\": false,\n" +
                "\t\"FormDateDomestic\": \"11/28 11:51\",\n" +
                "\t\"ClientNameDomestic\": \"张先\",\n" +
                "\t\"ArrivalAndDepartureDomestic\": \"11/28\",\n" +
                "\t\"HotelNameDisplay\": \"\",\n" +
                "\t\"TargetURL\": \"/ebkorderv2/domestic/orderlist.html?orderId=16881075854\",\n" +
                "\t\"EnableChooseSendSMS\": false,\n" +
                "\t\"DisableSendSMSReason\": \"订单已结束，不能联系客人\",\n" +
                "\t\"EnableChooseSendIM\": false,\n" +
                "\t\"DisableSendIMReason\": \"\",\n" +
                "\t\"orderDetail\": {\n" +
                "\t\t\"merchantRoomName\": null,\n" +
                "\t\t\"existOrderRemark\": false,\n" +
                "\t\t\"orderRemark\": null,\n" +
                "\t\t\"oriArrivalEarlyAndLatestTime\": null,\n" +
                "\t\t\"ctripTakeTotalFeehtml\": \"总代收费0.00\",\n" +
                "\t\t\"roomPriceText\": \"11-28(日) RMB56.95无早\\n\",\n" +
                "\t\t\"auditStatus\": -1,\n" +
                "\t\t\"isExpired\": true,\n" +
                "\t\t\"auditList\": [],\n" +
                "\t\t\"didEmail\": \"\",\n" +
                "\t\t\"locale\": \"zh\",\n" +
                "\t\t\"autoconfirmformstatus\": 0,\n" +
                "\t\t\"serviceScore\": null,\n" +
                "\t\t\"serviceScoreDeductText\": null,\n" +
                "\t\t\"limitColseDates\": [],\n" +
                "\t\t\"currentOrderStatus\": 9587,\n" +
                "\t\t\"productName\": null,\n" +
                "\t\t\"productDescription\": null,\n" +
                "\t\t\"productImages\": null,\n" +
                "\t\t\"isRoomTicketOrder\": false,\n" +
                "\t\t\"officialPaymentStatus\": null,\n" +
                "\t\t\"officialRefundStatusTxt\": null,\n" +
                "\t\t\"isEnquiryOrder\": false,\n" +
                "\t\t\"clientPhone\": null,\n" +
                "\t\t\"showDisabled\": true,\n" +
                "\t\t\"feeCancelDesc\": null,\n" +
                "\t\t\"feeCanceled\": false,\n" +
                "\t\t\"masterOrderId\": null,\n" +
                "\t\t\"partHotelCount\": null,\n" +
                "\t\t\"competeState\": null,\n" +
                "\t\t\"leftSeconds\": null,\n" +
                "\t\t\"ctripRemarkList\": [{\n" +
                "\t\t\t\t\"title\": \"支付方式\",\n" +
                "\t\t\t\t\"content\": \"房费携程支付，无需返服务费(周结)。房价保密、请不要向客人透露。\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"title\": \"预付订单酒店不向客人收房费，请保留房间\",\n" +
                "\t\t\t\t\"content\": \"预付订单，客人已支付房费，请贵酒店务必保留房间\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"title\": \"防疫信息\",\n" +
                "\t\t\t\t\"content\": \"携程在用户下单时在订单详情页的订房必读中，接收的订单确认短信中都展示了贵酒店防疫要求等信息，点击<a href='//ebooking.ctrip.com/htlUniv/SytUniversity/articleDetail?articleId=2642' target='_blank'>查看详情</a>。\"\n" +
                "\t\t\t}\n" +
                "\t\t],\n" +
                "\t\t\"oToken\": \"124E3F8E93FB3E44C4EE1D92C82E8E07\",\n" +
                "\t\t\"overturnLogs\": null,\n" +
                "\t\t\"orderTripCost\": null,\n" +
                "\t\t\"extFormType\": null,\n" +
                "\t\t\"expired\": true,\n" +
                "\t\t\"invoiceKey\": 0,\n" +
                "\t\t\"confirmName\": \"前台预订部\",\n" +
                "\t\t\"companyName\": null,\n" +
                "\t\t\"confirmStatus\": \"已接单(HE)\",\n" +
                "\t\t\"showOrderDate\": false,\n" +
                "\t\t\"contactInfo\": {\n" +
                "\t\t\t\"tel\": \"051380703261\",\n" +
                "\t\t\t\"telCaptcha\": \"175854\",\n" +
                "\t\t\t\"telCaptcha2\": \"1688\"\n" +
                "\t\t},\n" +
                "\t\t\"orgPaymentInfo\": null,\n" +
                "\t\t\"domesticPaymentInfo\": {\n" +
                "\t\t\t\"paymentMethod\": null,\n" +
                "\t\t\t\"settlingMethod\": null,\n" +
                "\t\t\t\"totalAmount\": \"56.95\",\n" +
                "\t\t\t\"addOptionalAmount\": null,\n" +
                "\t\t\t\"totalOrginAmount\": \"77.44\",\n" +
                "\t\t\t\"totalChildAmount\": null,\n" +
                "\t\t\t\"totalOrginSellPrice\": \"88.00\",\n" +
                "\t\t\t\"totalOrginCostPrice\": \"77.44\",\n" +
                "\t\t\t\"totalSellPrice\": \"65.00\",\n" +
                "\t\t\t\"totalCostPrice\": \"56.95\"\n" +
                "\t\t},\n" +
                "\t\t\"cashPledge\": null,\n" +
                "\t\t\"additionalOptional\": null,\n" +
                "\t\t\"lra\": false,\n" +
                "\t\t\"resend\": false,\n" +
                "\t\t\"contractNO\": null,\n" +
                "\t\t\"rejectedCancel\": false,\n" +
                "\t\t\"enableConfirm\": false,\n" +
                "\t\t\"hideBookingNO\": false,\n" +
                "\t\t\"priceMode\": 2,\n" +
                "\t\t\"confirmRemarks\": \"\",\n" +
                "\t\t\"arrivalAndDeparture\": \"2021/11/28\",\n" +
                "\t\t\"canSendSMS\": true,\n" +
                "\t\t\"showPCC\": false,\n" +
                "\t\t\"showVCC\": false,\n" +
                "\t\t\"historyCount\": 1,\n" +
                "\t\t\"officalSealPath\": null,\n" +
                "\t\t\"supplierName\": \"携程\",\n" +
                "\t\t\"bookDescription\": null,\n" +
                "\t\t\"invoiceToken\": \"CFCD208495D565EF66E7DFF9F98764DA\",\n" +
                "\t\t\"totalFee\": \"RMB 56.95（含服务费和税）\",\n" +
                "\t\t\"cancelPolicyText\": null,\n" +
                "\t\t\"purchaseCodes\": null,\n" +
                "\t\t\"pcctoVCC\": false,\n" +
                "\t\t\"originalOrderid\": 0,\n" +
                "\t\t\"rightInfoCancelPolicy\": null,\n" +
                "\t\t\"showLadderDeductPolicy\": false,\n" +
                "\t\t\"fullyBookedOrder\": false,\n" +
                "\t\t\"limitCancelHtml\": \"<tr>\\n<td><div class=\\\"view-txt ebk-c-gray\\\">北京时间2021-11-28 17:00:00前</div></td>\\n<td><div class=\\\"view-txt ebk-c-gray\\\">免费</div></td>\\n</tr><tr>\\n<td><div class=\\\"view-txt ebk-c-gray\\\">北京时间2021-11-28 17:00:00后</div></td>\\n<td><div class=\\\"view-txt ebk-c-gray\\\">全额房费</div></td>\\n</tr>\",\n" +
                "\t\t\"thOrderIdInfo\": null,\n" +
                "\t\t\"showRightsTrip\": false,\n" +
                "\t\t\"buyoutOrder\": false,\n" +
                "\t\t\"hotelMallOrder\": false,\n" +
                "\t\t\"rightOrder\": false,\n" +
                "\t\t\"unionMember\": false,\n" +
                "\t\t\"limitCancel\": true,\n" +
                "\t\t\"orderStatusDisplay\": \"已入住\",\n" +
                "\t\t\"showHotelName\": false,\n" +
                "\t\t\"amountDes\": \"RMB 56.95\",\n" +
                "\t\t\"sroomPice\": null,\n" +
                "\t\t\"sotherFee\": null,\n" +
                "\t\t\"sfeeType\": null,\n" +
                "\t\t\"changeSummary\": null,\n" +
                "\t\t\"officialOrderSource\": null,\n" +
                "\t\t\"arrivalEarlyAndLatestTime\": \"12:30-15:30\",\n" +
                "\t\t\"showMailTo\": false,\n" +
                "\t\t\"domesticOrder\": true,\n" +
                "\t\t\"overturnOrder\": false,\n" +
                "\t\t\"domestic\": null,\n" +
                "\t\t\"telPhone\": null,\n" +
                "\t\t\"guestMobilePhone\": null,\n" +
                "\t\t\"notifyType\": 0,\n" +
                "\t\t\"remarks\": \"\",\n" +
                "\t\t\"confirmOtherWayType\": \"\",\n" +
                "\t\t\"guaranteeType\": null,\n" +
                "\t\t\"freeRoomOrder\": false,\n" +
                "\t\t\"rightsVMInfo\": null,\n" +
                "\t\t\"roomTicketOrder\": false,\n" +
                "\t\t\"allicanceOrder\": false,\n" +
                "\t\t\"cancelTimeOut\": false,\n" +
                "\t\t\"competeOrder\": false,\n" +
                "\t\t\"refOrderID\": \"0\",\n" +
                "\t\t\"paymentTerm\": \"PP\",\n" +
                "\t\t\"fg\": false,\n" +
                "\t\t\"managementEmail\": \"\",\n" +
                "\t\t\"showRigthsInfo\": false,\n" +
                "\t\t\"orderRoomPrices\": [{\n" +
                "\t\t\t\"totalDailyPrice\": \"56.95\",\n" +
                "\t\t\t\"childTotalDailyPrice\": \"0\",\n" +
                "\t\t\t\"livingDate\": \"11-28(日)\",\n" +
                "\t\t\t\"originLivingDate\": \"2021-11-28\",\n" +
                "\t\t\t\"breakfast\": 0,\n" +
                "\t\t\t\"mealInfo\": \"不含餐\",\n" +
                "\t\t\t\"sellPrice\": \"65.00\",\n" +
                "\t\t\t\"costPrice\": \"56.95\",\n" +
                "\t\t\t\"roomPrice\": \"56.95\",\n" +
                "\t\t\t\"originSellPrice\": null,\n" +
                "\t\t\t\"originCostPrice\": null,\n" +
                "\t\t\t\"originRoomPrice\": \"77.44\",\n" +
                "\t\t\t\"promotionItems\": [{\n" +
                "\t\t\t\t\t\"sellGapPrice\": \"18.00\",\n" +
                "\t\t\t\t\t\"costGapPrice\": \"15.49\",\n" +
                "\t\t\t\t\t\"ruleName\": \"1719456\",\n" +
                "\t\t\t\t\t\"remark\": null,\n" +
                "\t\t\t\t\t\"currency\": \"RMB\",\n" +
                "\t\t\t\t\t\"name\": \"周末特惠（5-9折）\",\n" +
                "\t\t\t\t\t\"Name\": \"周末特惠（5-9折）\",\n" +
                "\t\t\t\t\t\"Currency\": \"RMB\",\n" +
                "\t\t\t\t\t\"CostGapPrice\": \"15.49\",\n" +
                "\t\t\t\t\t\"SellGapPrice\": \"18.00\",\n" +
                "\t\t\t\t\t\"RuleName\": \"1719456\",\n" +
                "\t\t\t\t\t\"Remark\": null\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"sellGapPrice\": \"5.00\",\n" +
                "\t\t\t\t\t\"costGapPrice\": \"5.00\",\n" +
                "\t\t\t\t\t\"ruleName\": null,\n" +
                "\t\t\t\t\t\"remark\": null,\n" +
                "\t\t\t\t\t\"currency\": \"RMB\",\n" +
                "\t\t\t\t\t\"name\": \"国内部分酒店满减券\",\n" +
                "\t\t\t\t\t\"Name\": \"国内部分酒店满减券\",\n" +
                "\t\t\t\t\t\"Currency\": \"RMB\",\n" +
                "\t\t\t\t\t\"CostGapPrice\": \"5.00\",\n" +
                "\t\t\t\t\t\"SellGapPrice\": \"5.00\",\n" +
                "\t\t\t\t\t\"RuleName\": null,\n" +
                "\t\t\t\t\t\"Remark\": null\n" +
                "\t\t\t\t}\n" +
                "\t\t\t],\n" +
                "\t\t\t\"rightBreakFirst\": 0,\n" +
                "\t\t\t\"orderChildPriceInfos\": null,\n" +
                "\t\t\t\"viewChildPriceInfos\": null,\n" +
                "\t\t\t\"dailyPriceHoverHtml\": \"<div class='txtl' >\\n<table>\\n<tbody>\\n<tr>\\n<td>折扣前房费</td>\\n<td>RMB77.44</td>\\n</tr><tr>\\n<td>周末特惠（5-9折）</td>\\n<td class='ebk-c-orange'>-RMB15.49</td>\\n</tr><tr>\\n<td>国内部分酒店满减券</td>\\n<td class='ebk-c-orange'>-RMB5.00</td>\\n</tr><tr class='floor-line'>\\n<td>折扣后房费</td>\\n<td>RMB56.95</td>\\n</tr>\\n</tbody>\\n</table>\\n</div> \",\n" +
                "\t\t\t\"domesticDailyPriceHoverHtml\": \"<div class='txtl rate-table'>\\n<table class='table'><thead><tr></tr></thead>\\n<tbody>\\n<tr>\\n<td>折扣前房费</td>\\n<td>77.44</td>\\n</tr><tr>\\n<td>周末特惠（5-9折）</td>\\n<td class='ebk-c-orange'>-15.49</td>\\n</tr><tr>\\n<td>国内部分酒店满减券</td>\\n<td class='ebk-c-orange'>-5.00</td>\\n</tr><tr class='floor-line'>\\n<td>折扣后房费</td>\\n<td>56.95</td>\\n</tr>\\n</tbody>\\n</table>\\n</div> \",\n" +
                "\t\t\t\"guidCurrency\": null,\n" +
                "\t\t\t\"currency\": \"RMB\",\n" +
                "\t\t\t\"LivingDate\": \"11-28(日)\",\n" +
                "\t\t\t\"OriginLivingDate\": \"2021-11-28\",\n" +
                "\t\t\t\"RoomPrice\": \"56.95\",\n" +
                "\t\t\t\"CostPrice\": \"56.95\",\n" +
                "\t\t\t\"SellPrice\": \"65.00\",\n" +
                "\t\t\t\"Currency\": \"RMB\",\n" +
                "\t\t\t\"Breakfast\": 0,\n" +
                "\t\t\t\"OriginSellPrice\": null,\n" +
                "\t\t\t\"ViewChildPriceInfos\": null,\n" +
                "\t\t\t\"ChildTotalDailyPrice\": \"0\",\n" +
                "\t\t\t\"TotalDailyPrice\": \"56.95\",\n" +
                "\t\t\t\"MealInfo\": \"不含餐\",\n" +
                "\t\t\t\"DailyPriceHoverHtml\": \"<div class='txtl' >\\n<table>\\n<tbody>\\n<tr>\\n<td>折扣前房费</td>\\n<td>RMB77.44</td>\\n</tr><tr>\\n<td>周末特惠（5-9折）</td>\\n<td class='ebk-c-orange'>-RMB15.49</td>\\n</tr><tr>\\n<td>国内部分酒店满减券</td>\\n<td class='ebk-c-orange'>-RMB5.00</td>\\n</tr><tr class='floor-line'>\\n<td>折扣后房费</td>\\n<td>RMB56.95</td>\\n</tr>\\n</tbody>\\n</table>\\n</div> \",\n" +
                "\t\t\t\"RightBreakFirst\": 0,\n" +
                "\t\t\t\"DomesticDailyPriceHoverHtml\": \"<div class='txtl rate-table'>\\n<table class='table'><thead><tr></tr></thead>\\n<tbody>\\n<tr>\\n<td>折扣前房费</td>\\n<td>77.44</td>\\n</tr><tr>\\n<td>周末特惠（5-9折）</td>\\n<td class='ebk-c-orange'>-15.49</td>\\n</tr><tr>\\n<td>国内部分酒店满减券</td>\\n<td class='ebk-c-orange'>-5.00</td>\\n</tr><tr class='floor-line'>\\n<td>折扣后房费</td>\\n<td>56.95</td>\\n</tr>\\n</tbody>\\n</table>\\n</div> \"\n" +
                "\t\t}],\n" +
                "\t\t\"showChildPirce\": false,\n" +
                "\t\t\"childInfos\": null,\n" +
                "\t\t\"vcctoPCC\": false,\n" +
                "\t\t\"commonRemark\": \"\",\n" +
                "\t\t\"spRemarks\": \"\",\n" +
                "\t\t\"ctripRemarks\": \"<b>支付方式：</b>房费携程支付，无需返服务费(周结)。房价保密、请不要向客人透露。<br><b>预付：</b>预付订单，客人已支付房费，请贵酒店务必保留房间<br><b>防疫信息：</b>携程在用户下单时在订单详情页的订房必读中，接收的订单确认短信中都展示了贵酒店防疫要求等信息，点击<a href='//ebooking.ctrip.com/htlUniv/SytUniversity/articleDetail?articleId=2642' target='_blank'>查看详情</a>。<br>\",\n" +
                "\t\t\"guaranteeTypeTips\": null,\n" +
                "\t\t\"giftInfo\": \"\",\n" +
                "\t\t\"promotionInfo\": \"\",\n" +
                "\t\t\"existCostGapPrice\": true,\n" +
                "\t\t\"existSellGapPrice\": true,\n" +
                "\t\t\"changes\": null,\n" +
                "\t\t\"balancePeriod\": \"W\",\n" +
                "\t\t\"paymentInfo\": {\n" +
                "\t\t\t\"paymentMethod\": \"预付\",\n" +
                "\t\t\t\"settlingMethod\": null,\n" +
                "\t\t\t\"totalAmount\": \"RMB 56.95\",\n" +
                "\t\t\t\"addOptionalAmount\": null,\n" +
                "\t\t\t\"totalOrginAmount\": \"RMB 77.44\",\n" +
                "\t\t\t\"totalChildAmount\": null,\n" +
                "\t\t\t\"totalOrginSellPrice\": \"RMB 88.00\",\n" +
                "\t\t\t\"totalOrginCostPrice\": \"RMB 77.44\",\n" +
                "\t\t\t\"totalSellPrice\": \"RMB 65.00\",\n" +
                "\t\t\t\"totalCostPrice\": \"RMB 56.95\"\n" +
                "\t\t},\n" +
                "\t\t\"freeCancelPolicy\": false,\n" +
                "\t\t\"cancelPolicyTitle\": \"限时取消\",\n" +
                "\t\t\"ladderDeductPolicy\": null,\n" +
                "\t\t\"bookingNO\": \"\",\n" +
                "\t\t\"canModifyBookingNO\": true,\n" +
                "\t\t\"historys\": [{\n" +
                "\t\t\t\"orderID\": 16881075854,\n" +
                "\t\t\t\"subOrders\": [{\n" +
                "\t\t\t\t\"ctripSourceType\": \"EBK\",\n" +
                "\t\t\t\t\"ebkOrderID\": 1543999180,\n" +
                "\t\t\t\t\"formDate\": 1638071506942,\n" +
                "\t\t\t\t\"formDateDisplay\": \"11-28 11:51\",\n" +
                "\t\t\t\t\"formID\": 1520979026,\n" +
                "\t\t\t\t\"orderType\": \"已接单\",\n" +
                "\t\t\t\t\"orderID\": 16881075854,\n" +
                "\t\t\t\t\"orderStatus\": 100,\n" +
                "\t\t\t\t\"ctripSourceTypeDisplay\": \"EBK\",\n" +
                "\t\t\t\t\"originalOrderID\": 16881075854,\n" +
                "\t\t\t\t\"isUseless\": false,\n" +
                "\t\t\t\t\"isUnprocess\": false,\n" +
                "\t\t\t\t\"isSelected\": true,\n" +
                "\t\t\t\t\"isTop\": true,\n" +
                "\t\t\t\t\"isBottom\": true,\n" +
                "\t\t\t\t\"Token\": \"9513CAE777AD43C5548892373B480C8B\",\n" +
                "\t\t\t\t\"HotelId\": 0\n" +
                "\t\t\t}]\n" +
                "\t\t}],\n" +
                "\t\t\"refOrderRemarks\": null,\n" +
                "\t\t\"delayStaySalePrice\": null,\n" +
                "\t\t\"delayStayCostPrice\": null,\n" +
                "\t\t\"preModifyOrder\": false,\n" +
                "\t\t\"hotelInvoice\": true,\n" +
                "\t\t\"longTerm\": false,\n" +
                "\t\t\"monthlyRentOrder\": false,\n" +
                "\t\t\"setMealOrder\": false,\n" +
                "\t\t\"bidOrder\": false,\n" +
                "\t\t\"conToOffline\": false,\n" +
                "\t\t\"fullRoomOrder\": false,\n" +
                "\t\t\"imComfirmOrder\": null,\n" +
                "\t\t\"otaCtOrder\": false,\n" +
                "\t\t\"outsideOrder\": false,\n" +
                "\t\t\"childPriceOrder\": false,\n" +
                "\t\t\"ctripSourceTypeDisplay\": \"EBK\",\n" +
                "\t\t\"bedType\": \"大床\",\n" +
                "\t\t\"invoice\": {\n" +
                "\t\t\t\"info\": \"如客人索取发票，请贵酒店开具，开票金额：RMB 60.00。\",\n" +
                "\t\t\t\"dailyAmount\": [{\n" +
                "\t\t\t\t\"date\": \"2021-11-29\",\n" +
                "\t\t\t\t\"currency\": null,\n" +
                "\t\t\t\t\"amount\": \"60.00\"\n" +
                "\t\t\t}]\n" +
                "\t\t},\n" +
                "\t\t\"bookingInvoice\": false,\n" +
                "\t\t\"invoiceApplyType\": 0,\n" +
                "\t\t\"groupOrderType\": 0,\n" +
                "\t\t\"autoOpenRoom\": false,\n" +
                "\t\t\"hotelMallInfoList\": null,\n" +
                "\t\t\"hotelMallCostPirce\": null,\n" +
                "\t\t\"hotelMallSalePirce\": null,\n" +
                "\t\t\"buttonListDisplay\": [],\n" +
                "\t\t\"preModifyFormStatus\": 0,\n" +
                "\t\t\"preChanges\": null,\n" +
                "\t\t\"xcsmz\": false,\n" +
                "\t\t\"thOrderId\": null,\n" +
                "\t\t\"canSendSMSDomestic\": true,\n" +
                "\t\t\"enquiryOrder\": false,\n" +
                "\t\t\"childTotalPrice\": null,\n" +
                "\t\t\"orderKey\": null,\n" +
                "\t\t\"clientName\": \"张先\",\n" +
                "\t\t\"sourceType\": \"Ebooking\",\n" +
                "\t\t\"orderID\": \"16881075854\",\n" +
                "\t\t\"hotel\": 1719461,\n" +
                "\t\t\"mainLand\": false,\n" +
                "\t\t\"formID\": 1520979026,\n" +
                "\t\t\"ctripOrderSourceType\": \"EBK\",\n" +
                "\t\t\"amount\": \"56.95\",\n" +
                "\t\t\"autoConfirmed\": null,\n" +
                "\t\t\"orderStatus\": 100,\n" +
                "\t\t\"orderType\": \"N\",\n" +
                "\t\t\"promotionList\": [{\n" +
                "\t\t\t\t\"sellGapPrice\": \"0.00\",\n" +
                "\t\t\t\t\"costGapPrice\": \"15.49\",\n" +
                "\t\t\t\t\"ruleName\": \"1719456\",\n" +
                "\t\t\t\t\"remark\": \"按间夜(1天*1间)\",\n" +
                "\t\t\t\t\"currency\": \"RMB\",\n" +
                "\t\t\t\t\"name\": \"周末特惠（5-9折）8折\",\n" +
                "\t\t\t\t\"Name\": \"周末特惠（5-9折）8折\",\n" +
                "\t\t\t\t\"Currency\": \"RMB\",\n" +
                "\t\t\t\t\"CostGapPrice\": \"15.49\",\n" +
                "\t\t\t\t\"SellGapPrice\": \"0.00\",\n" +
                "\t\t\t\t\"RuleName\": \"1719456\",\n" +
                "\t\t\t\t\"Remark\": \"按间夜(1天*1间)\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"sellGapPrice\": \"0.00\",\n" +
                "\t\t\t\t\"costGapPrice\": \"5.00\",\n" +
                "\t\t\t\t\"ruleName\": null,\n" +
                "\t\t\t\t\"remark\": \"按间夜(1天*1间)\",\n" +
                "\t\t\t\t\"currency\": \"RMB\",\n" +
                "\t\t\t\t\"name\": \"国内部分酒店满减券\",\n" +
                "\t\t\t\t\"Name\": \"国内部分酒店满减券\",\n" +
                "\t\t\t\t\"Currency\": \"RMB\",\n" +
                "\t\t\t\t\"CostGapPrice\": \"5.00\",\n" +
                "\t\t\t\t\"SellGapPrice\": \"0.00\",\n" +
                "\t\t\t\t\"RuleName\": null,\n" +
                "\t\t\t\t\"Remark\": \"按间夜(1天*1间)\"\n" +
                "\t\t\t}\n" +
                "\t\t],\n" +
                "\t\t\"guaranteed\": false,\n" +
                "\t\t\"showSalePrice\": false,\n" +
                "\t\t\"showCostPrice\": true,\n" +
                "\t\t\"riskyOrder\": false,\n" +
                "\t\t\"con\": false,\n" +
                "\t\t\"guests\": 1,\n" +
                "\t\t\"liveDays\": -1,\n" +
                "\t\t\"token\": \"9513CAE777AD43C5548892373B480C8B\",\n" +
                "\t\t\"arrival\": \"2021-11-28\",\n" +
                "\t\t\"departure\": \"2021-11-29\",\n" +
                "\t\t\"paymentType\": \"预付\",\n" +
                "\t\t\"formDate\": \"2021-11-28 11:51:46\",\n" +
                "\t\t\"quantity\": 1,\n" +
                "\t\t\"roomName\": \"优选大床房<无早>(钟点房)<09:00到17:00,连住3小时>\",\n" +
                "\t\t\"roomEnName\": \"优选大床房<无早>(钟点房)<09:00到17:00,连住3小时>\",\n" +
                "\t\t\"hotelName\": \"优派酒店(中山前陇店)\",\n" +
                "\t\t\"hotelEName\": \"Youpai Cabaret\",\n" +
                "\t\t\"totalCostPrice\": null,\n" +
                "\t\t\"totalSalePrice\": null,\n" +
                "\t\t\"showPriceType\": null,\n" +
                "\t\t\"urgent\": false,\n" +
                "\t\t\"riskyType\": null,\n" +
                "\t\t\"pp\": true,\n" +
                "\t\t\"allinanceName\": \"ctrip\",\n" +
                "\t\t\"holdRoom\": false,\n" +
                "\t\t\"freeSale\": false,\n" +
                "\t\t\"creditOrder\": false,\n" +
                "\t\t\"orderStatusType\": \"CheckIn\",\n" +
                "\t\t\"hourRom\": true,\n" +
                "\t\t\"roomID\": 939417578,\n" +
                "\t\t\"showGuidedPrice\": false,\n" +
                "\t\t\"childCount\": 0,\n" +
                "\t\t\"currency\": \"RMB\",\n" +
                "\t\t\"OrderID\": \"16881075854\",\n" +
                "\t\t\"FormID\": 1520979026,\n" +
                "\t\t\"OrderKey\": null,\n" +
                "\t\t\"FormDate\": \"2021-11-28 11:51:46\",\n" +
                "\t\t\"OrderDate\": \"2021-11-28 11:51:43\",\n" +
                "\t\t\"Token\": \"9513CAE777AD43C5548892373B480C8B\",\n" +
                "\t\t\"SourceType\": \"Ebooking\",\n" +
                "\t\t\"CtripOrderSourceType\": \"EBK\",\n" +
                "\t\t\"OrderType\": \"N\",\n" +
                "\t\t\"OrderStatus\": 100,\n" +
                "\t\t\"OrderStatusType\": \"CheckIn\",\n" +
                "\t\t\"RoomName\": \"优选大床房<无早>(钟点房)<09:00到17:00,连住3小时>\",\n" +
                "\t\t\"RoomEnName\": \"优选大床房<无早>(钟点房)<09:00到17:00,连住3小时>\",\n" +
                "\t\t\"RoomID\": 939417578,\n" +
                "\t\t\"Hotel\": 1719461,\n" +
                "\t\t\"HotelName\": \"优派酒店(中山前陇店)\",\n" +
                "\t\t\"HotelEName\": \"Youpai Cabaret\",\n" +
                "\t\t\"Quantity\": 1,\n" +
                "\t\t\"Arrival\": \"2021-11-28\",\n" +
                "\t\t\"Departure\": \"2021-11-29\",\n" +
                "\t\t\"LiveDays\": -1,\n" +
                "\t\t\"Guests\": 1,\n" +
                "\t\t\"Currency\": \"RMB\",\n" +
                "\t\t\"Amount\": \"56.95\",\n" +
                "\t\t\"TotalCostPrice\": null,\n" +
                "\t\t\"TotalSalePrice\": null,\n" +
                "\t\t\"IsShowSalePrice\": false,\n" +
                "\t\t\"IsShowCostPrice\": true,\n" +
                "\t\t\"ShowGuidedPrice\": false,\n" +
                "\t\t\"ShowPriceType\": null,\n" +
                "\t\t\"PaymentType\": \"预付\",\n" +
                "\t\t\"PromotionList\": [{\n" +
                "\t\t\t\t\"sellGapPrice\": \"0.00\",\n" +
                "\t\t\t\t\"costGapPrice\": \"15.49\",\n" +
                "\t\t\t\t\"ruleName\": \"1719456\",\n" +
                "\t\t\t\t\"remark\": \"按间夜(1天*1间)\",\n" +
                "\t\t\t\t\"currency\": \"RMB\",\n" +
                "\t\t\t\t\"name\": \"周末特惠（5-9折）8折\",\n" +
                "\t\t\t\t\"Name\": \"周末特惠（5-9折）8折\",\n" +
                "\t\t\t\t\"Currency\": \"RMB\",\n" +
                "\t\t\t\t\"CostGapPrice\": \"15.49\",\n" +
                "\t\t\t\t\"SellGapPrice\": \"0.00\",\n" +
                "\t\t\t\t\"RuleName\": \"1719456\",\n" +
                "\t\t\t\t\"Remark\": \"按间夜(1天*1间)\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"sellGapPrice\": \"0.00\",\n" +
                "\t\t\t\t\"costGapPrice\": \"5.00\",\n" +
                "\t\t\t\t\"ruleName\": null,\n" +
                "\t\t\t\t\"remark\": \"按间夜(1天*1间)\",\n" +
                "\t\t\t\t\"currency\": \"RMB\",\n" +
                "\t\t\t\t\"name\": \"国内部分酒店满减券\",\n" +
                "\t\t\t\t\"Name\": \"国内部分酒店满减券\",\n" +
                "\t\t\t\t\"Currency\": \"RMB\",\n" +
                "\t\t\t\t\"CostGapPrice\": \"5.00\",\n" +
                "\t\t\t\t\"SellGapPrice\": \"0.00\",\n" +
                "\t\t\t\t\"RuleName\": null,\n" +
                "\t\t\t\t\"Remark\": \"按间夜(1天*1间)\"\n" +
                "\t\t\t}\n" +
                "\t\t],\n" +
                "\t\t\"ClientName\": \"张先\",\n" +
                "\t\t\"IsHoldRoom\": false,\n" +
                "\t\t\"IsUrgent\": false,\n" +
                "\t\t\"IsFreeSale\": false,\n" +
                "\t\t\"IsCreditOrder\": false,\n" +
                "\t\t\"IsGuaranteed\": false,\n" +
                "\t\t\"GuaranteeType\": null,\n" +
                "\t\t\"IsAutoConfirmed\": null,\n" +
                "\t\t\"IsCON\": false,\n" +
                "\t\t\"IsPP\": true,\n" +
                "\t\t\"IsRiskyOrder\": false,\n" +
                "\t\t\"RiskyType\": null,\n" +
                "\t\t\"ChildCount\": 0,\n" +
                "\t\t\"AllinanceName\": \"ctrip\",\n" +
                "\t\t\"IsHourRoom\": true,\n" +
                "\t\t\"HourRoomInfo\": null,\n" +
                "\t\t\"PaymentInfo\": {\n" +
                "\t\t\t\"paymentMethod\": \"预付\",\n" +
                "\t\t\t\"settlingMethod\": null,\n" +
                "\t\t\t\"totalAmount\": \"RMB 56.95\",\n" +
                "\t\t\t\"addOptionalAmount\": null,\n" +
                "\t\t\t\"totalOrginAmount\": \"RMB 77.44\",\n" +
                "\t\t\t\"totalChildAmount\": null,\n" +
                "\t\t\t\"totalOrginSellPrice\": \"RMB 88.00\",\n" +
                "\t\t\t\"totalOrginCostPrice\": \"RMB 77.44\",\n" +
                "\t\t\t\"totalSellPrice\": \"RMB 65.00\",\n" +
                "\t\t\t\"totalCostPrice\": \"RMB 56.95\"\n" +
                "\t\t},\n" +
                "\t\t\"PriceMode\": 2,\n" +
                "\t\t\"GiftInfo\": \"\",\n" +
                "\t\t\"giftName\": \"查看详情\",\n" +
                "\t\t\"NotifyType\": 0,\n" +
                "\t\t\"CommonRemark\": \"\",\n" +
                "\t\t\"CtripRemarks\": \"<b>支付方式：</b>房费携程支付，无需返服务费(周结)。房价保密、请不要向客人透露。<br><b>预付：</b>预付订单，客人已支付房费，请贵酒店务必保留房间<br><b>防疫信息：</b>携程在用户下单时在订单详情页的订房必读中，接收的订单确认短信中都展示了贵酒店防疫要求等信息，点击<a href='//ebooking.ctrip.com/htlUniv/SytUniversity/articleDetail?articleId=2642' target='_blank'>查看详情</a>。<br>\",\n" +
                "\t\t\"ConfirmRemarks\": \"\",\n" +
                "\t\t\"RefOrderRemarks\": null,\n" +
                "\t\t\"ConfirmName\": \"前台预订部\",\n" +
                "\t\t\"ConfirmStatus\": \"已接单(HE)\",\n" +
                "\t\t\"BookingNO\": \"\",\n" +
                "\t\t\"CanModifyBookingNO\": true,\n" +
                "\t\t\"ArrivalEarlyAndLatestTime\": \"12:30-15:30\",\n" +
                "\t\t\"AdditionalOptional\": null,\n" +
                "\t\t\"OrderRoomPrices\": [{\n" +
                "\t\t\t\"totalDailyPrice\": \"56.95\",\n" +
                "\t\t\t\"childTotalDailyPrice\": \"0\",\n" +
                "\t\t\t\"livingDate\": \"11-28(日)\",\n" +
                "\t\t\t\"originLivingDate\": \"2021-11-28\",\n" +
                "\t\t\t\"breakfast\": 0,\n" +
                "\t\t\t\"mealInfo\": \"不含餐\",\n" +
                "\t\t\t\"sellPrice\": \"65.00\",\n" +
                "\t\t\t\"costPrice\": \"56.95\",\n" +
                "\t\t\t\"roomPrice\": \"56.95\",\n" +
                "\t\t\t\"originSellPrice\": null,\n" +
                "\t\t\t\"originCostPrice\": null,\n" +
                "\t\t\t\"originRoomPrice\": \"77.44\",\n" +
                "\t\t\t\"promotionItems\": [{\n" +
                "\t\t\t\t\t\"sellGapPrice\": \"18.00\",\n" +
                "\t\t\t\t\t\"costGapPrice\": \"15.49\",\n" +
                "\t\t\t\t\t\"ruleName\": \"1719456\",\n" +
                "\t\t\t\t\t\"remark\": null,\n" +
                "\t\t\t\t\t\"currency\": \"RMB\",\n" +
                "\t\t\t\t\t\"name\": \"周末特惠（5-9折）\",\n" +
                "\t\t\t\t\t\"Name\": \"周末特惠（5-9折）\",\n" +
                "\t\t\t\t\t\"Currency\": \"RMB\",\n" +
                "\t\t\t\t\t\"CostGapPrice\": \"15.49\",\n" +
                "\t\t\t\t\t\"SellGapPrice\": \"18.00\",\n" +
                "\t\t\t\t\t\"RuleName\": \"1719456\",\n" +
                "\t\t\t\t\t\"Remark\": null\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"sellGapPrice\": \"5.00\",\n" +
                "\t\t\t\t\t\"costGapPrice\": \"5.00\",\n" +
                "\t\t\t\t\t\"ruleName\": null,\n" +
                "\t\t\t\t\t\"remark\": null,\n" +
                "\t\t\t\t\t\"currency\": \"RMB\",\n" +
                "\t\t\t\t\t\"name\": \"国内部分酒店满减券\",\n" +
                "\t\t\t\t\t\"Name\": \"国内部分酒店满减券\",\n" +
                "\t\t\t\t\t\"Currency\": \"RMB\",\n" +
                "\t\t\t\t\t\"CostGapPrice\": \"5.00\",\n" +
                "\t\t\t\t\t\"SellGapPrice\": \"5.00\",\n" +
                "\t\t\t\t\t\"RuleName\": null,\n" +
                "\t\t\t\t\t\"Remark\": null\n" +
                "\t\t\t\t}\n" +
                "\t\t\t],\n" +
                "\t\t\t\"rightBreakFirst\": 0,\n" +
                "\t\t\t\"orderChildPriceInfos\": null,\n" +
                "\t\t\t\"viewChildPriceInfos\": null,\n" +
                "\t\t\t\"dailyPriceHoverHtml\": \"<div class='txtl' >\\n<table>\\n<tbody>\\n<tr>\\n<td>折扣前房费</td>\\n<td>RMB77.44</td>\\n</tr><tr>\\n<td>周末特惠（5-9折）</td>\\n<td class='ebk-c-orange'>-RMB15.49</td>\\n</tr><tr>\\n<td>国内部分酒店满减券</td>\\n<td class='ebk-c-orange'>-RMB5.00</td>\\n</tr><tr class='floor-line'>\\n<td>折扣后房费</td>\\n<td>RMB56.95</td>\\n</tr>\\n</tbody>\\n</table>\\n</div> \",\n" +
                "\t\t\t\"domesticDailyPriceHoverHtml\": \"<div class='txtl rate-table'>\\n<table class='table'><thead><tr></tr></thead>\\n<tbody>\\n<tr>\\n<td>折扣前房费</td>\\n<td>77.44</td>\\n</tr><tr>\\n<td>周末特惠（5-9折）</td>\\n<td class='ebk-c-orange'>-15.49</td>\\n</tr><tr>\\n<td>国内部分酒店满减券</td>\\n<td class='ebk-c-orange'>-5.00</td>\\n</tr><tr class='floor-line'>\\n<td>折扣后房费</td>\\n<td>56.95</td>\\n</tr>\\n</tbody>\\n</table>\\n</div> \",\n" +
                "\t\t\t\"guidCurrency\": null,\n" +
                "\t\t\t\"currency\": \"RMB\",\n" +
                "\t\t\t\"LivingDate\": \"11-28(日)\",\n" +
                "\t\t\t\"OriginLivingDate\": \"2021-11-28\",\n" +
                "\t\t\t\"RoomPrice\": \"56.95\",\n" +
                "\t\t\t\"CostPrice\": \"56.95\",\n" +
                "\t\t\t\"SellPrice\": \"65.00\",\n" +
                "\t\t\t\"Currency\": \"RMB\",\n" +
                "\t\t\t\"Breakfast\": 0,\n" +
                "\t\t\t\"OriginSellPrice\": null,\n" +
                "\t\t\t\"ViewChildPriceInfos\": null,\n" +
                "\t\t\t\"ChildTotalDailyPrice\": \"0\",\n" +
                "\t\t\t\"TotalDailyPrice\": \"56.95\",\n" +
                "\t\t\t\"MealInfo\": \"不含餐\",\n" +
                "\t\t\t\"DailyPriceHoverHtml\": \"<div class='txtl' >\\n<table>\\n<tbody>\\n<tr>\\n<td>折扣前房费</td>\\n<td>RMB77.44</td>\\n</tr><tr>\\n<td>周末特惠（5-9折）</td>\\n<td class='ebk-c-orange'>-RMB15.49</td>\\n</tr><tr>\\n<td>国内部分酒店满减券</td>\\n<td class='ebk-c-orange'>-RMB5.00</td>\\n</tr><tr class='floor-line'>\\n<td>折扣后房费</td>\\n<td>RMB56.95</td>\\n</tr>\\n</tbody>\\n</table>\\n</div> \",\n" +
                "\t\t\t\"RightBreakFirst\": 0,\n" +
                "\t\t\t\"DomesticDailyPriceHoverHtml\": \"<div class='txtl rate-table'>\\n<table class='table'><thead><tr></tr></thead>\\n<tbody>\\n<tr>\\n<td>折扣前房费</td>\\n<td>77.44</td>\\n</tr><tr>\\n<td>周末特惠（5-9折）</td>\\n<td class='ebk-c-orange'>-15.49</td>\\n</tr><tr>\\n<td>国内部分酒店满减券</td>\\n<td class='ebk-c-orange'>-5.00</td>\\n</tr><tr class='floor-line'>\\n<td>折扣后房费</td>\\n<td>56.95</td>\\n</tr>\\n</tbody>\\n</table>\\n</div> \"\n" +
                "\t\t}],\n" +
                "\t\t\"IsShowPCC\": false,\n" +
                "\t\t\"IsShowVCC\": false,\n" +
                "\t\t\"IsVCCToPCC\": false,\n" +
                "\t\t\"IsShowMailTo\": false,\n" +
                "\t\t\"PromotionInfo\": \"\",\n" +
                "\t\t\"Changes\": null,\n" +
                "\t\t\"ChangeSummary\": null,\n" +
                "\t\t\"TotalFee\": \"RMB 56.95（含服务费和税）\",\n" +
                "\t\t\"CancelPolicyTitle\": \"限时取消\",\n" +
                "\t\t\"CancelPolicyText\": null,\n" +
                "\t\t\"SpRemarks\": \"\",\n" +
                "\t\t\"ExistSellGapPrice\": true,\n" +
                "\t\t\"ExistCostGapPrice\": true,\n" +
                "\t\t\"IsPCCToVCC\": false,\n" +
                "\t\t\"LadderDeductPolicy\": null,\n" +
                "\t\t\"ladderDeductPolicyV2\": null,\n" +
                "\t\t\"IsCanSendSMS\": true,\n" +
                "\t\t\"ContactInfo\": {\n" +
                "\t\t\t\"tel\": \"051380703261\",\n" +
                "\t\t\t\"telCaptcha\": \"175854\",\n" +
                "\t\t\t\"telCaptcha2\": \"1688\"\n" +
                "\t\t},\n" +
                "\t\t\"IsShowLadderDeductPolicy\": false,\n" +
                "\t\t\"ShowChildPirce\": false,\n" +
                "\t\t\"IsLimitCancel\": true,\n" +
                "\t\t\"LimitCancelHtml\": \"<tr>\\n<td><div class=\\\"view-txt ebk-c-gray\\\">北京时间2021-11-28 17:00:00前</div></td>\\n<td><div class=\\\"view-txt ebk-c-gray\\\">免费</div></td>\\n</tr><tr>\\n<td><div class=\\\"view-txt ebk-c-gray\\\">北京时间2021-11-28 17:00:00后</div></td>\\n<td><div class=\\\"view-txt ebk-c-gray\\\">全额房费</div></td>\\n</tr>\",\n" +
                "\t\t\"ChildInfos\": null,\n" +
                "\t\t\"ChildTotalPrice\": null,\n" +
                "\t\t\"ConfirmOtherWayType\": \"\",\n" +
                "\t\t\"ShowType\": 2,\n" +
                "\t\t\"GuestMobilePhone\": null,\n" +
                "\t\t\"IsTelPhone\": null,\n" +
                "\t\t\"IsDomestic\": null,\n" +
                "\t\t\"OrderFeeInfos\": [],\n" +
                "\t\t\"OrderFeeOrgCurrency\": null,\n" +
                "\t\t\"OrderStatusDisplay\": \"已入住\",\n" +
                "\t\t\"CtripSourceTypeDisplay\": \"EBK\",\n" +
                "\t\t\"ArrivalAndDeparture\": \"2021/11/28\",\n" +
                "\t\t\"BedType\": \"大床\",\n" +
                "\t\t\"DomesticPaymentInfo\": {\n" +
                "\t\t\t\"paymentMethod\": null,\n" +
                "\t\t\t\"settlingMethod\": null,\n" +
                "\t\t\t\"totalAmount\": \"56.95\",\n" +
                "\t\t\t\"addOptionalAmount\": null,\n" +
                "\t\t\t\"totalOrginAmount\": \"77.44\",\n" +
                "\t\t\t\"totalChildAmount\": null,\n" +
                "\t\t\t\"totalOrginSellPrice\": \"88.00\",\n" +
                "\t\t\t\"totalOrginCostPrice\": \"77.44\",\n" +
                "\t\t\t\"totalSellPrice\": \"65.00\",\n" +
                "\t\t\t\"totalCostPrice\": \"56.95\"\n" +
                "\t\t},\n" +
                "\t\t\"Historys\": [{\n" +
                "\t\t\t\"orderID\": 16881075854,\n" +
                "\t\t\t\"subOrders\": [{\n" +
                "\t\t\t\t\"ctripSourceType\": \"EBK\",\n" +
                "\t\t\t\t\"ebkOrderID\": 1543999180,\n" +
                "\t\t\t\t\"formDate\": 1638071506942,\n" +
                "\t\t\t\t\"formDateDisplay\": \"11-28 11:51\",\n" +
                "\t\t\t\t\"formID\": 1520979026,\n" +
                "\t\t\t\t\"orderType\": \"已接单\",\n" +
                "\t\t\t\t\"orderID\": 16881075854,\n" +
                "\t\t\t\t\"orderStatus\": 100,\n" +
                "\t\t\t\t\"ctripSourceTypeDisplay\": \"EBK\",\n" +
                "\t\t\t\t\"originalOrderID\": 16881075854,\n" +
                "\t\t\t\t\"isUseless\": false,\n" +
                "\t\t\t\t\"isUnprocess\": false,\n" +
                "\t\t\t\t\"isSelected\": true,\n" +
                "\t\t\t\t\"isTop\": true,\n" +
                "\t\t\t\t\"isBottom\": true,\n" +
                "\t\t\t\t\"Token\": \"9513CAE777AD43C5548892373B480C8B\",\n" +
                "\t\t\t\t\"HotelId\": 0\n" +
                "\t\t\t}]\n" +
                "\t\t}],\n" +
                "\t\t\"ShowRigthsInfo\": false,\n" +
                "\t\t\"ShowRightsTrip\": false,\n" +
                "\t\t\"CashPledge\": null,\n" +
                "\t\t\"DelayStaySalePrice\": null,\n" +
                "\t\t\"DelayStayCostPrice\": null,\n" +
                "\t\t\"AmountDes\": \"RMB 56.95\",\n" +
                "\t\t\"Invoice\": {\n" +
                "\t\t\t\"info\": \"如客人索取发票，请贵酒店开具，开票金额：RMB 60.00。\",\n" +
                "\t\t\t\"dailyAmount\": [{\n" +
                "\t\t\t\t\"date\": \"2021-11-29\",\n" +
                "\t\t\t\t\"currency\": null,\n" +
                "\t\t\t\t\"amount\": \"60.00\"\n" +
                "\t\t\t}]\n" +
                "\t\t},\n" +
                "\t\t\"RightsVMInfo\": null,\n" +
                "\t\t\"OfficalSealPath\": null,\n" +
                "\t\t\"SupplierName\": \"携程\",\n" +
                "\t\t\"CompanyName\": null,\n" +
                "\t\t\"BookDescription\": null,\n" +
                "\t\t\"IsLRA\": false,\n" +
                "\t\t\"IsResend\": false,\n" +
                "\t\t\"IsBookingInvoice\": false,\n" +
                "\t\t\"GuaranteeTypeTips\": null,\n" +
                "\t\t\"InvoiceApplyType\": 0,\n" +
                "\t\t\"InvoiceKey\": 0,\n" +
                "\t\t\"InvoiceToken\": \"CFCD208495D565EF66E7DFF9F98764DA\",\n" +
                "\t\t\"GroupOrderType\": 0,\n" +
                "\t\t\"IsBuyoutOrder\": false,\n" +
                "\t\t\"IsHotelMallOrder\": false,\n" +
                "\t\t\"IsRightOrder\": false,\n" +
                "\t\t\"IsFullyBookedOrder\": false,\n" +
                "\t\t\"Xcsmz\": false,\n" +
                "\t\t\"IsFG\": false,\n" +
                "\t\t\"PurchaseCodes\": null,\n" +
                "\t\t\"HotelMallInfoList\": null,\n" +
                "\t\t\"HotelMallSalePirce\": null,\n" +
                "\t\t\"HotelMallCostPirce\": null,\n" +
                "\t\t\"SRoomPice\": null,\n" +
                "\t\t\"SOtherFee\": null,\n" +
                "\t\t\"SFeeType\": null,\n" +
                "\t\t\"ContractNO\": null,\n" +
                "\t\t\"RejectedCancel\": false,\n" +
                "\t\t\"ButtonListDisplay\": [],\n" +
                "\t\t\"EnableConfirm\": false,\n" +
                "\t\t\"HideBookingNO\": false,\n" +
                "\t\t\"RightInfoCancelPolicy\": null,\n" +
                "\t\t\"receiveType\": \"HE\",\n" +
                "\t\t\"bedRemarks\": \"\",\n" +
                "\t\t\"Remarks\": \"\",\n" +
                "\t\t\"policyNo\": null,\n" +
                "\t\t\"PreModifyFormStatus\": 0,\n" +
                "\t\t\"IsShowHotelName\": false,\n" +
                "\t\t\"IsDomesticOrder\": true,\n" +
                "\t\t\"ThOrderId\": null,\n" +
                "\t\t\"ThOrderIdInfo\": null,\n" +
                "\t\t\"FreeCancelPolicy\": false,\n" +
                "\t\t\"HistoryCount\": 1,\n" +
                "\t\t\"IsCanSendSMSDomestic\": true,\n" +
                "\t\t\"IsUnionMember\": false,\n" +
                "\t\t\"OfficialOrderSource\": null,\n" +
                "\t\t\"BalancePeriod\": \"W\",\n" +
                "\t\t\"IsAllicanceOrder\": false,\n" +
                "\t\t\"AllicanceTag\": null,\n" +
                "\t\t\"isCancelTimeOut\": false,\n" +
                "\t\t\"WholePromotionTip\": null,\n" +
                "\t\t\"MutiOrderInfo\": null,\n" +
                "\t\t\"IsPreModifyOrder\": false,\n" +
                "\t\t\"isHotelInvoice\": true,\n" +
                "\t\t\"OrderComplainInfoList\": null,\n" +
                "\t\t\"ComplainStatus\": null,\n" +
                "\t\t\"IsLongTerm\": false,\n" +
                "\t\t\"CertificateInfoList\": null,\n" +
                "\t\t\"OrderFaqInfoList\": null,\n" +
                "\t\t\"OrderFaqStatus\": null,\n" +
                "\t\t\"CustomLan\": \"中文\",\n" +
                "\t\t\"IsSetMealOrder\": false,\n" +
                "\t\t\"MealOrderInfo\": null,\n" +
                "\t\t\"checkInPkgInfo\": null,\n" +
                "\t\t\"BidOrderInfoList\": null,\n" +
                "\t\t\"IsBidOrder\": false,\n" +
                "\t\t\"BidOrderText\": null,\n" +
                "\t\t\"OrderInterventionInfoList\": null,\n" +
                "\t\t\"OrderInterventionStatus\": null,\n" +
                "\t\t\"IsMonthlyRentOrder\": false,\n" +
                "\t\t\"ShowSupplierFeeCancel\": null,\n" +
                "\t\t\"isCompeteOrder\": false,\n" +
                "\t\t\"IsConToOffline\": false,\n" +
                "\t\t\"ConToOfflineReason\": \"\",\n" +
                "\t\t\"isAutoOpenRoom\": false,\n" +
                "\t\t\"isShowOrderDate\": false,\n" +
                "\t\t\"SpecialRemarkVMList\": null,\n" +
                "\t\t\"isOverturnOrder\": false,\n" +
                "\t\t\"ProcessId\": null,\n" +
                "\t\t\"IsChildPriceOrder\": false,\n" +
                "\t\t\"RoomLimitPersonCountDesc\": null,\n" +
                "\t\t\"GuestInputPersonCountDesc\": null,\n" +
                "\t\t\"CustomerBadInfo\": null,\n" +
                "\t\t\"IsFullRoomOrder\": false,\n" +
                "\t\t\"IsImComfirmOrder\": null,\n" +
                "\t\t\"IsOtaCtOrder\": false,\n" +
                "\t\t\"UnionMemberPriceRemark\": null,\n" +
                "\t\t\"orderCOVIDInfo\": \"携程在用户下单时在订单详情页的订房必读中，接收的订单确认短信中都展示了贵酒店防疫要求等信息，点击<a href='//ebooking.ctrip.com/htlUniv/SytUniversity/articleDetail?articleId=2642' target='_blank'>查看详情</a>。\",\n" +
                "\t\t\"IsFreeRoomOrder\": false,\n" +
                "\t\t\"IsOutsideOrder\": false,\n" +
                "\t\t\"OrderCompanyInfo\": null\n" +
                "\t}\n" +
                "}]";
        System.out.println(JSON.toJSONString(text));
    }

    public static void testFlie() {
        StringBuffer buffer = new StringBuffer();
        try (FileInputStream fileInputStream = new FileInputStream("/Users/jiangguanfeng/Desktop/未命名.txt");
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
             FileOutputStream fileOutputStream = new FileOutputStream("/Users/jiangguanfeng/Desktop/未命名1.txt");
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);) {
            byte[] buf = new byte[1024];
            int len = 0;
            while (bufferedInputStream.read(buf) != -1) {
                bufferedOutputStream.write(buf);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        try (FileReader fileReader = new FileReader("/Users/jiangguanfeng/Desktop/未命名.txt");
             FileWriter fileWriter = new FileWriter("/Users/jiangguanfeng/Desktop/未命名1.txt")) {
            char[] buf = new char[1024];
            int len = 0;
            while ((len = fileReader.read(buf)) != -1) {
                fileWriter.write(new String(buf, 0, len));
                fileWriter.flush();
            }

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void grabXc() throws Exception {
        try (WebClient webClient = new WebClient(BrowserVersion.CHROME)) {

            HtmlPage searchPage = webClient.getPage("https://ebooking.ctrip.com/ebkorderv2/domestic/orderlist.html?micro=true&tab=4");
        }
        URL getUrl = new URL("https://ebooking.ctrip.com/ebkorderv2/domestic/orderlist.html?micro=true&tab=4");
        HttpURLConnection connection = (HttpURLConnection) getUrl
                .openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "*/*");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36");
        connection.setRequestProperty("Accept-Language", "zh-cn");
        //connection.setRequestProperty("Content-Type","text/html;charset=utf-8");
        connection.setRequestProperty("Cookie", "vc=6; _RSG=gDKodQILuz73ABhjLnXxZ9; _RDG=281038e0f3530c294f088767a2744b7ca4; _RGUID=7f785526-a7c9-436a-98fb-87156dacb283; _bfaStatusPVSend=1; OrderCount=0; VoiceType=c_d; logintype=1; userRole_9162133=director; ebk_user_token=5880ca54-c534-4309-9dbe-da9a80ab6ffa; autoLogin=F; GUID=09031162116964013441; CurrentLanguage=SimpChinese; ibulanguage=CN; ibulocale=zh_cn; cookiePricesDisplayed=CNY; _abtest_userid=fd11a70f-3816-4b70-8932-5fb4cd4c4c96; _gcl_au=1.1.1711836473.1656295316; Session=smartlinkcode=U130026&smartlinklanguage=zh&SmartLinkKeyWord=&SmartLinkQuary=&SmartLinkHost=; MKT_CKID=1656295317069.3opt7.kx4l; __zpspc=9.1.1656295317.1656295317.1%232%7Cwww.baidu.com%7C%7C%7C%7C%23; appFloatCnt=1; _ga=GA1.2.688993314.1656295317; _jzqco=%7C%7C%7C%7C1656295317277%7C1.175547390.1656295317075.1656295317075.1656295317075.1656295317075.1656295317075.undefined.0.0.1.1; usersign=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpcCI6IjE0MC4yMDUuMTEuNjQiLCJpc3MiOiIxMDAwMDc0MjciLCJodWlkIjo5MTYyMTMzLCJwd2QiOiJERERDODBCRTVFNzZDMDFBQTQ4RTdGNjUwQzYwMEQ1QyIsImV4cCI6MTY1ODk4NjQzN30.DVsCW5qpJLI6qucHPYSIyzSJBS6sygVlUFJ9o82-zXM; randomkey=eb460423-0a20-4276-8151-b83bee2a240d; usertoken=eb460423-0a20-4276-8151-b83bee2a240d; imislogin=9162133^1; imticket=5745EBEAD980A6BB7C256FD0087A1859ED0CC839E26C3CD579796DCB65BF0A53; imuid=_IMEB4952860012; _RF1=140.205.11.67; hotelhst=1164390341; _bfi=p1%3D10650061100%26p2%3D10650009638%26v1%3D108%26v2%3D107; _bfaStatus=success; _bfa=1.1644827284560.2c6lvx.1.1657596819772.1657607870312.24.109.2259; _bfs=1.13; _ubtstatus=%7B%22vid%22%3A%221644827284560.2c6lvx%22%2C%22sid%22%3A24%2C%22pvid%22%3A109%2C%22pid%22%3A0%7D");
        connection.setRequestProperty("sec-ch-ua", "\".Not/A)Brand\";v=\"99\", \"Google Chrome\";v=\"103\", \"Chromium\";v=\"103\"");
        connection.connect();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
        String line;
        StringBuffer result = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }
        anaXc(result.toString());
    }

    public static void anaXc(String html) {
        Document doc = Jsoup.parse(html);
        System.out.println("抓取内容展示");
/*        Elements Tags = doc.getElementsByTag("img");
        for (Element img : imgs) {
            String imgSrc = img.attr("src");
            if (imgSrc.startsWith("//")) {
                imgSrc = "http:" + imgSrc;
            }
        }*/
    }
}
