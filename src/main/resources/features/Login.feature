Feature: Proses User Login
# 1
  Scenario: Sistem menangani skenario di mana user mencoba login dengan menggunakan kredensial yang valid
    Given User berada di halaman login
    When User memasukan username yang salah
    And User memasukan password yang salah
    And User klik tombol login
    When Sistem menampilkan pesan kesalahan Invalid credentials
    Then User memasukan username yang valid
    And User memasukan password yang valid
    And User klik tombol login
    And User berhasil login dan diarahkan ke halaman utama atau dashboard
#  # 2
#  Scenario: User dapat berhasil login dengan menggunakan kredensial yang valid
#    Given User mengakses halaman login
#    When User memasukan username yang valid
#    And User memasukan password yang valid
#    And User klik tombol login
#    Then User berhasil login dan diarahkan ke halaman utama atau dashboard
#  # 2
  #3
#  Scenario: Sistem menangani skenario di mana user mencoba login dengan menggunakan password yang salah
#    Given User masih berada di halaman login
#    When User memasukan username yang valid
#    And User memasukan password yang salah
#    And User klik tombol login
#    Then Sistem menampilkan pesan kesalahan Invalid credentials
