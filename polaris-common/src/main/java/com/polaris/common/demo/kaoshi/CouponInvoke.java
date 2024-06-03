package com.polaris.common.demo.kaoshi;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 获取红包支付方式
 */
public class CouponInvoke {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor tp = new ThreadPoolExecutor(5, 10, 3000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(500));
        List<String> payList = new ArrayList<>();
        payList.add("coupon");
        payList.add("balance");
        List<Future<SubConsultResult>> futureList = new ArrayList<>();
        for (int i = 0; i < payList.size(); i++) {
            Future<SubConsultResult> f = tp.submit(new InvokeTask(payList.get(i)));
            futureList.add(f);
        }
        List<String> avablePayList = new ArrayList<>();
        for (Future<SubConsultResult> f : futureList) {
            if (f.get().isEnable()) {
                avablePayList.add(f.get().getPayment());
            }
        }
        System.out.println("可用的支付列表：" + avablePayList);
    }

    @Data
    public static class InvokeTask implements Callable<SubConsultResult> {
        private String payment;

        public InvokeTask(String payment) {
            this.payment = payment;
        }

        @Override
        public SubConsultResult call() throws Exception {
            ConsultResult cr = isEnable(payment);
            SubConsultResult scr = new SubConsultResult(payment);
            scr.setEnable(cr.isEnable());
            scr.setErrorCode(cr.getErrorCode());
            return scr;
        }
    }

    public static ConsultResult isEnable(String paymentType) {
        ConsultResult consultResult = new ConsultResult();
        consultResult.setEnable(true);
        return consultResult;
    }

    @Data
    public static class ConsultResult implements Serializable {

        private boolean isEnable;

        private String errorCode;
    }

    @Data
    public static class SubConsultResult extends ConsultResult {
        public SubConsultResult(String payment) {
            this.payment = payment;
        }

        private String payment;
    }
}
