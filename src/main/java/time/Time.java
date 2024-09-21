package time;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Time {

    // 임금 계산 메소드
    public static int calculateWage(int totalMinutesWorked, int hourlyWage) {
        int totalWage = 0;

        if (totalMinutesWorked <= 360) { // 6시간 이하 근무 시
            totalWage = totalMinutesWorked * hourlyWage / 60;
        } else if (totalMinutesWorked <= 480) { // 6시간 초과 8시간 이하 근무 시
            totalWage = (totalMinutesWorked - 45) * hourlyWage / 60; // 45분 휴식 제외
        } else { // 8시간 초과 근무 시
            int regularPay = (480 - 60) * hourlyWage / 60; // 8시간에서 1시간 휴식 제외
            int overtimeMinutes = totalMinutesWorked - 480; // 초과된 시간
            int overtimePay = (int) (overtimeMinutes * hourlyWage * 1.25 / 60); // 초과 근무 1.25배 시급
            totalWage = regularPay + overtimePay;
        }

        return totalWage;
    }

    public static void main(String[] args) {
        // CSV 파일 경로
        final String WORKING_RESULT_FILE_PATH = "./src/time/WorkingResult.csv";
        final String COMMA = ",";

        // 시간 및 임금 관련 상수
        final long ONE_HOUR_BY_MILLI_SEC = 1000 * 60 * 60; // 1시간을 밀리초로 변환
        final long ONE_MIN_BY_MILLI_SEC = 1000 * 60; // 1분을 밀리초로 변환
        final int HOURLY_WAGE = 900; // 시급 (예: 900엔)

        // 근무 결과를 저장할 리스트
        List<String> workingResults = new ArrayList<>();

        try {
            // CSV 파일 읽기
            File workingResultFile = new File(WORKING_RESULT_FILE_PATH);
            BufferedReader br = new BufferedReader(new FileReader(workingResultFile));

            String record = br.readLine();
            while (record != null) {
                workingResults.add(record);
                record = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        double totalSalary = 0; // 총 월급
        for (String workingRecord : workingResults) {
            String[] forSplitRecord = workingRecord.split(COMMA); // CSV에서 콤마로 분리

            Date workingDate = Date.valueOf(forSplitRecord[0]); // 근무일
            java.sql.Time startTime = java.sql.Time.valueOf(forSplitRecord[1]); // 출근 시간
            java.sql.Time finishTime = java.sql.Time.valueOf(forSplitRecord[2]); // 퇴근 시간

            // 근무 시간(밀리초 단위)을 계산
            long workingTime = finishTime.getTime() - startTime.getTime();

            // 밀리초를 시간과 분으로 변환
            int workingHour = (int) (workingTime / ONE_HOUR_BY_MILLI_SEC); // 시간 계산
            int workingMin = (int) ((workingTime / ONE_MIN_BY_MILLI_SEC) % 60); // 분 계산
            int totalMinutesWorked = workingHour * 60 + workingMin; // 총 근무 시간(분 단위)

            // 임금 계산
            int wage = calculateWage(totalMinutesWorked, HOURLY_WAGE);

            // 출력
            System.out.println("【日付】" + workingDate + " / " +
                    "【勤務時間】" + startTime + "～" + finishTime + " / " +
                    "【労働時間】" + workingHour + "時間" + workingMin + "分 / " +
                    "【賃金】" + wage + "円");

            // 총 월급 계산
            totalSalary += wage;
        }

        // 총 월급 출력
        System.out.println("【総賃金】" + totalSalary + "円");
    }
}
