
def make_change(amount, coins):
    if sum(coins) < amount:
        print(f'{coins} sums to {sum(coins)} which is smaller than {amount}')
        return []
    # if amount in coins:
    #     print(f'{amount} found in {coins}')
    #     return [amount]
    out = []
    starting_amount = amount
    while sum(out) < starting_amount:
        biggest = max(coins)
        current_coin = biggest
        for coin in sorted(coins):
            if coin == 0:
                continue
            if coin >= amount:
                print(coin)
                current_coin = coin
                break
        amount -= current_coin
        coins.remove(current_coin)
        out.append(current_coin)
    return out

if __name__ == '__main__':
    coins = [10, 10, 5, 5, 1, 1, 1, 1, 5, 25]
    amount = 24
    l = make_change(amount, coins)
    print(l)
