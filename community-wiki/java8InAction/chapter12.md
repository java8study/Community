# CHAPTER. 12 새로운 날짜와 시간 API

### 최초 java.util.Date 는 날짜와 시간 표현에 있어 애매하고 유용성 떨어짐
  * 1900년을 기준으로 하는 오프셋과 0에서 시작하는 달
  
ex) Date date = new Date(114, 2, 18);

  * Tue Mar 18 00:00:00 CET 2014



### 이후 대안으로 Calendar 등장했지만 혼란 증폭
  * DateFormat (날짜 형식 조정 및 파싱에 사용) 사용 불가



### LocalDate / LocalTime / Instant / Duration / Period
  * 새로울 날짜와 시간 API 사용시 처음 접하는 것이 LocalDate 클래스
  
ex) LocalDate date = LocalDate.of(2014, 3, 18);

int year = date.getYear(); // 2014

Month month = date.getMonth(); // MARCH

int day = date.getDayOfMonth(); // 18

DayOfWeek dow = date.getDayOfWe다; // TUESDAY


  * TemporalField 전달하여 정보를 얻는 방법
  
ex) int year = date.get(ChronoField.YEAR);

int month = date.get(ChronoField.MONTH_OF_YEAR);

int day = date.get(ChronoField.DAY_OF_MONTH);


  * 시간은 LocalTime 클래스로 표현
  
ex) LocalTime time = LocalTime.of(13, 45, 20);

int hour = time.getHour(); // 13

int minute = time.getMinute(); // 45

int second = time.getSecond(); // 20


  * 날짜와 시간 문자열로 생성 가능
  
ex) LocalDate date = LocalDate.parse(“2014-03-18”);

      LocalTime time = LocalTime.parse(“13:45:20”);
      
      
  * 날짜와 시간 조합 가능
    
ex) LocalDateTime dt = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
    2014-03-18T13:45:20
      
      
  * 기계의 날짜와 시간
  사람의 주, 월, 시간 단위가 아닌 기계 관점의 특정 지점을 하나의 큰 수로 표현

  * 두 시간 객체 사이의 지속시간은 Duration 클래스로 표현
  LocalTime / LocalDateTime / Instant 사용 가능
  초와 나노초로 시간단위를 표현하므로 LocalDate 사용불가


  * 년, 월, 일로 시간을 표현할 때는 Period 클래스로 표현
  
ex) Period tenDays = Period.between(LocalDate.of(2014, 3, 8),
                                    LocalDate.of(2014, 3, 18));



### 날짜 조정 / 파싱 / 포매팅
  * widthAttribute (절대적인 방식)
날짜를 조정하며 기존 객체를 바꾸찌 않음

  * plus / minus (상대적인 방식)
  
ex) LocalDate date1 = LocalDate.of(2014, 3, 18); // 2014-03-18

      LocalDate date2 = date1.plusWeeks(1); // 2014-03-25
      
      LocalDate date3 = date2.minusYears(3); // 2011-03-25


  * 파싱과 포매팅은 전용패키지 java.time.format 제공
  DateTimeFormatter 클래스 제공

  * 반대로 문자열을 파싱하여 날짜 객체 생성
  
ex) LocalDate date1 = LocalDate.parse("20140318", DateTimeFormatter.BASIC_ISO_DATE);

      LocalDate date2 = LocalDate.parse("20140318", DateTimeFormatter.ISO_LOCAL_DATE);   
      
