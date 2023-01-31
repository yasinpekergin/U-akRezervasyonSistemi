-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 19 Haz 2021, 10:06:09
-- Sunucu sürümü: 10.4.19-MariaDB
-- PHP Sürümü: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `odev`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `bildirim`
--

CREATE TABLE `bildirim` (
  `id` int(11) NOT NULL,
  `Tarih` text COLLATE utf8_turkish_ci NOT NULL,
  `Bildirim` text COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `bildirim`
--

INSERT INTO `bildirim` (`id`, `Tarih`, `Bildirim`) VALUES
(1, '12.06.2021', 'Bügün Tüm Uçaklar 08.00 Kalkacaktır .'),
(3, '2023', 'sa'),
(4, '2023', 'assss'),
(5, '2030', 'Emir Kaya ');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `k_bilet`
--

CREATE TABLE `k_bilet` (
  `id` int(11) NOT NULL,
  `Git` text COLLATE utf8_turkish_ci NOT NULL,
  `HavaYolu` text COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `k_bilet`
--

INSERT INTO `k_bilet` (`id`, `Git`, `HavaYolu`) VALUES
(1, 'comboBoxChanged', 'comboBoxChanged'),
(2, 'Türk Hava Yolları', '\"Adıyaman\"'),
(3, 'Pegasus', '\"Adıyaman\"'),
(4, 'Türk Hava Yolları', '\"Adana\"'),
(5, 'Pegasus', '\"Adıyaman\"'),
(6, 'Seçiniz', 'Seçiniz'),
(7, 'Türk Hava Yolları', '\"Afyonkarahisar\"'),
(8, 'Pegasus', '\"Adıyaman\"'),
(9, 'AnadoluJet', '\"Bingöl\"');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `k_kayit`
--

CREATE TABLE `k_kayit` (
  `id` int(11) NOT NULL,
  `Adi` text COLLATE utf8_turkish_ci NOT NULL,
  `Soyad` text COLLATE utf8_turkish_ci NOT NULL,
  `Tarih` text COLLATE utf8_turkish_ci NOT NULL,
  `Tel` text COLLATE utf8_turkish_ci NOT NULL,
  `TC` text COLLATE utf8_turkish_ci NOT NULL,
  `pass` text COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `k_kayit`
--

INSERT INTO `k_kayit` (`id`, `Adi`, `Soyad`, `Tarih`, `Tel`, `TC`, `pass`) VALUES
(2, 'Çetin', 'Y', '05.05.2000', '538', '123', 'abc'),
(3, 'Emir', 'DemirKaya', '20.05.2000', '533', '159', 'abc');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `k_koltuk`
--

CREATE TABLE `k_koltuk` (
  `id` int(11) NOT NULL,
  `ToplamBilet` int(50) NOT NULL,
  `MevcutBilet` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `k_koltuk`
--

INSERT INTO `k_koltuk` (`id`, `ToplamBilet`, `MevcutBilet`) VALUES
(1, 98, 2);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `y_kayit`
--

CREATE TABLE `y_kayit` (
  `id` int(11) NOT NULL,
  `adi` text COLLATE utf8_turkish_ci NOT NULL,
  `sifre` text COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `y_kayit`
--

INSERT INTO `y_kayit` (`id`, `adi`, `sifre`) VALUES
(1, 'admin', 'admin0');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `bildirim`
--
ALTER TABLE `bildirim`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `k_bilet`
--
ALTER TABLE `k_bilet`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `k_kayit`
--
ALTER TABLE `k_kayit`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `k_koltuk`
--
ALTER TABLE `k_koltuk`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `y_kayit`
--
ALTER TABLE `y_kayit`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `bildirim`
--
ALTER TABLE `bildirim`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Tablo için AUTO_INCREMENT değeri `k_bilet`
--
ALTER TABLE `k_bilet`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Tablo için AUTO_INCREMENT değeri `k_kayit`
--
ALTER TABLE `k_kayit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Tablo için AUTO_INCREMENT değeri `k_koltuk`
--
ALTER TABLE `k_koltuk`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Tablo için AUTO_INCREMENT değeri `y_kayit`
--
ALTER TABLE `y_kayit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
