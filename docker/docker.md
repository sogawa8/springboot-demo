# 開発用データベースの作成
docker-compose-database.yml が配置されているフォルダに移動し、以下のコマンドを実行する。
```
$ docker-compose -f docker-compose-database.yml up -d
```
以下のように done となれば起動している。立ち上がるまでに少し時間がかかるため、2,3分後にアクセス可能となる。
```
Recreating db         ... done
Recreating phpmyadmin ... done
```
# phpMyAdmin へのアクセス
mysql の管理ツールである phpMyAdmin も同時に起動する。以下のURLからアクセス可能。  
http://localhost:20080/

# データベースの設定
クライアントが割り当てているポート番号は、23306 、ただし、docker 内の割り当ては 3306 となっているため、接続元の環境によってポートを使い分ける必要がある。  
root のパスワードは root で設定している。