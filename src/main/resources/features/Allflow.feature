Feature: Proses User Checkout
# 1
  Scenario: User Checkout Akan Product
    Given User berada di halaman login1
    When User memasukan kredensial yang salah
    Then User memasukan kredensial yang benar
    When User menambahkan product ke dalam cart1
    Then User Checkout Product1
    When User memasukan informasi yang salah1
    Then User memasukkan informasi yang benar1