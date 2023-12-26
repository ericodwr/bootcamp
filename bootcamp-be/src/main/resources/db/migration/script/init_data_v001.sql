-- t_file
INSERT INTO t_file (file_extens, file_name, created_by, created_at, is_active, ver) VALUES
	('.png', 'iVBORw0KGgoAAAANSUhEUgAAAgAAAAIACAYAAAD0eNT6AAAABHNCSVQICAgIfAhkiAAAAAlwSFlzAAAOxAAADsQBlSsOGwAAABl0RVh0U29mdHdhcmUAd3d3Lmlua3NjYXBlLm9yZ5vuPBoAACAASURBVHic7d15vF1VefDx372ZBwiQEAiEUUHmUUQQRERQVAaLQq1Ktait81tb0dqq9LWDI63w6keUitVSrWMpiJQqIgZQRBkjyBjGBJJAQuaQ5PaPdfOSwE1y78161tr7nN/381mfm1b7dD/nrLP2s9feey2QJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJEmSJDVaT+0DkJTFdsBuwO79bUdgG2ASsGX/37Vt4rP+b1cBi9b5n5cAj/W3ucDjwJz+f88B7gYeAPpiUpFUggWA1C47Ay8CDgP2Ip3sdwMmFD6OJcCdwB3A7/r/PRO4B1hT+FgkDYMFgNRck3nmZL+2bVf1iDZtIXBtf/sF8GtgedUjkjQgCwCpOUaQTvKvBk4EDgF6qx7R5lsB3EgqBq4CrgaernlAkiQ1wWTgDcAFwKOk++qd3J4EvgOcSXo2QZKkrjEBeAvwE2A19U/KtdpS4BLgbaQHFiVJ6kiHkq70n6L+ybdpbQVpZuAVeGtSktQBdgbOAe6j/km2Le0u4Gxg6tA/bkmS6joIuJj0wFvtE2pb2wrgu8AxQ/zsJUkq7ijgUtK78LVPoJ3UZgAn4e0BSVKD9JJOTr+i/omy09vNpDcI2v56pCSp5V4H/J76J8Zua7cCZ2AhIEkq7DDSoja1T4Td3n4LHL3xr0qSpM23E+lVvm5+f7+J7VJg1w1/bZIkDc+WwOdI69rXPtnZBm5LgI8D4zbwHUqSNCSv4pntb23Nb7OAPxjoi5QkaTC2Ik33+0pfO9t3SHstSJI0aK8FHqb+Scy2eW0OcAqSJG3CVNKVY+0Tly1v+yqwBZIkDeAovOrv5HY/8DIkAS6rKUH6HXwQ+BQwsvKx5LIKmN3f5q/TlpPW2F+6zn93DDC+v40hXSlvAewCTAe2LnbU8dYAHwP+kVQUSF3LAkDdbhJwEWlFvzaaB9wC3AbcTtp18H7STMaqTP8/JpB2NZwO7E7a6OggYP/+/6yNfgC8FVhU+TgkSRUcCNxN/anpwbaVwC+Bc4HTgB3yfyRDMgLYC/hD4J9IRUjtz2gobSawZ/ZPRZLUaG8kTYPXPgltqt0HfJG02VAbrra3B94MfB14hPqf36baAtIbH5KkLvAhmv1u/0zgE8A+UR9AQS8kraD4EPU/1w211aTnArwlKkkdqhc4j/onnIHabNJDiPuFZV9XL/BS4EvAXOp/3gO1L+PugpLUccYC36P+SebZV55XkJatHRWXeuOMBv6I9DxD7e/g2e3b/ccnSeoAWwM/p/7JZW1bDnyDzpji31yHkpZbXkb972Vt+ykuGiRJrbcd6Z567ZNKH+mBs78lrTao9e0AfJbmPJh5LZ21/oEkdZUpNOPVtEXAPwDbxKbbEXYgvfWwgvrf2y3AtNh0JUm5bQ3cRN0TyNPA+cC2wbl2ot1IrxKuou53OJNUSEqSWmAScAN1TxxX4D3+HPYHZlD3u7wBnwmQpMabSLp/W+tk8SBwcniW3aUHOIu07HGt7/WnpH0SJEkNNA64mjoniNWke9dbRifZxaaQ9m2otYjTD0jLH0uSGqSH9A53jRPDvaSthFXGsaSZlhrf9ddwxUBJapRzqHNC+DreH65hG+D71PnOP1MgP0nSIJxB+WnhJ4HTSySnjXonsITyRcBbSiQnSdqwF1F+8ZhbgT1KJKdB2Zv0nZTsA0uBQ0okJ0l6rh2Ahyk78H+LdmzL220mAj+kbF94ANd4kKTixgK/pdxgvwb4SJHMNFy9wKcpWwT8FBhZIjlJUvIFyg3yy0m716kd3kjZzYU+VyYtSdKrKffQ33x8xa+NjiY9qFmqCDijTFqS1L2mArMpM6g/BhxYJi0FOBiYS5m+sgDYqUxaktR9eoDLKDOgPwrsWyYtBdqb9F2W6DNX4iJBkhTig5QZyB8g7UanzlCyCPjTQjlJUtfYn/QwXokrf9/x7zx7AA8R338WAbsXykmSOl4vZXb4mwvsVygnlbcP8ATx/WgGbhokSVm8k/hBezHwwlIJqZqXUWYm6YOF8pGkjjWF+Ce5VwGnlEpI1Z1O2r45sk8tAXYulZAkdaJvEn+19r5i2agpSjxQ+s1i2UhSh3k58Qv+nF8sGzXNBcT2rTXAEcWykaQOMRq4k9gBegYwqlRCapyxwI3E9rEbSA+xSpIG6b3EDsxzgB2LZaOm2gWYR2xfe1uxbCSp5cYTu3DLKuClxbJR051M7K2m2cCWxbKRpBY7m9grsr8rl4pa4lPY5ySpqknETsneiPf99VwjiX0eYCGwdbFsJKmF/pa4QXgJLvOrDTsYWElc//t4uVQkqV0mk66UogbgvyiXilrq74jrf/OBLcqlIknt8Y/EDb6/xvXZtWljgJnE9cOzy6UiSe0wnnSFFDHorgQOLJeKWu7FpDdFIvriHGBcuVQkqfkiN/z554J5qDN8hbj++P6CeUhSo/UAtxEz2M7Dp681dNOARcT0yftwdUBJAuAVxF1tvbtgHuosnyCuX55QMA9JaqxLiBlk7yC93y0NxwTiVqT8bsE8JKmRdiXugaszyqWhDvV2YvrmStJtBknqWlFLsN6K91m1+UaQZpIi+uiHC+YhSY3SA8wiZnD9g3JpqMNFzQLcTfoNSFLXOYqYgfVOvPpXPmOAR4jpqy8vmIe0HgdJ1RR1j/5c0vauUg4rgPODYr85KK4kNdYI0qpoua+oHsOV1pTflsAC8vfXefimiipxBkC1vBzYLiDul4FlAXHV3Z4C/iUg7mTSrTBJ6hoXkf9qajWwS8kk1FWeT7q1lLvfulS1pK4xEniC/APpZSWTUFf6Bfn77Sx8G0BSlziC/INoH3BKySTUld5BTN89pGQSEvgMgOo4LiDmXOBHAXGldX2HmGdMTg2IKW2UBYBqOD4g5g9ISwpLkRaS9q7I7cSAmJLUKBNJ71XnnkI9tmQS6monkr//Pg1sUTIJSSrtNeQfPGeT1hWQShhNei0wdz+OmBmTNshbACrtFQExLyO9AiiVsBL4aUBc1wNQURYAKi1i7fMrAmJKG3N5QMyjA2JKUiOMI93rzH3vdFLJJCRgOvkXBVpKur0gFeEMgEran/zrnl9HejJbKulh4PbMMcfhegAqyAJAJR0UEPPqgJjSYPw4IOYRATGlAVkAqKSDA2LOCIgpDcb1ATH3CYgpSdVdT957pqvx/r/qmUb+VwEtaCV1nF5gMXkHy1uKZiA918Pk7dPzyx6+upm3AFTKnsCEzDFvzBxPGqpfZ463DbBd5pjSgCwAVMoLAmLmfgpbGqrcBQDA3gExpeewAFAp0wNi3hoQUxqK3wTEtABQERYAKmWngJgWAKrtroCYFgAqwgJApeycOd6TwNzMMaWheoi0GmVOO2aOJw3IAkCl5J4BmJU5njQcq0hFQE5TM8eTBmQBoFIsANSp7s0cz7cAVIQFgEroJS2aktP9meNJw3Vf5njOAKgICwCVMJX8u5zNzhxPGq5ZmeNNAsZmjik9hwWAStgiIOa8gJjScDwRENNZAIWzAFAJ4wNiumSqmiJiO2oLAIWzAFAJ4wJiWgCoKSIKgK0CYkrrsQBQCREFwFMBMaXhiOiLIwNiSuuxAFAJEbcAVgTElIYjYgZgREBMaT0WACohYgZgZUBMaTgWBcR0BkDhLABUQsQMgAWAmqInIKYzAApnAaAScq8BALA6IKY0HBEna2cAFM4CQCXk3iwFXChFzRFxsnYGQOEsAFRCxAN7EbcVpOGIOFlbACicBYBKiJgBiHiwUBqOUQExFwfElNZjAaASnAFQJ4soAFznQuEsAFRCRAHgDICaYkpAzIi1BaT1WACohCcDYk4MiCkNR8S6/c4AKJwFgEqI2Llvh4CY0nBsHxBzQUBMaT0WACohYuOenQJiSsPhDIBayQJAJSwi/3MAFgBqiu0yx1uOe12oAAsAlZJ7FmB65njScOW+BfB45njSgCwAVMojmePtnDmeNFx7ZY53b+Z40oAsAFTK/Znj7YCrpam+ieSfjcr9W5EGZAGgUmZljjcG2DNzTGmo9iL/boD3ZY4nDcgCQKXMCoh5UEBMaSj2DohpAaAiLABUSsS0pgWAast9/x8sAFSIBYBKuTMgpgWAats/IKYFgKSO0kNa37wvY3usaAbS+npIq1zm7NOuAKhinAFQKX3AbZljTsX1AFTPPsDkzDF/mzmetEEWACrp1oCYxwbElAbj6ICYNwTElAZkAaCScs8AALwiIKY0GBEFwK8DYkpSdS8k7/3SPmA2+d/DlgbjAfL3Z/e4kNSRRgKLyT9o7lsyCYm0CFXufjynaAbqet4CUEmriLnH6W0AlfYHATG9/6+iLABU2rUBMU8MiCltzCkBMW8MiClJjXEi+adOVwJTSiahrrYDsJr8/filJZOQpNImAMvJP3j+Wckk1NXeRf7+uwAYVTIJyVsAKm0JMbcB3hgQUxrIqQExrwSeDogrSY3yIfJfQa3GVQEVbzrpYdbc/fdtJZOQwBkA1fHjgJi9wOkBcaV1nQWMyByzD/jvzDElqbEeJP9V1O24KJDijCBm8Z/flExCWssZANXyg4CY+wLHBcSVAF4J7BwQ9/KAmJLUWEeS/0qqD/ivkkmoq/yQmD57WMkkJKm2HmJuA6wGnlcwD3WHnUlP6efur3eUTEJal7cAVEsf8N2AuL3AewPiqrudTdrLIrd/DYgpSY33ImKmVBcAWxXMQ51te2AZMbNV7v4nqWvdTEwR8H9LJqGO9lli+uiVJZOQpKZ5PzGD6yJgasE81JkmA08R00ffXDAPSWqcrYGlxAyw5xbMQ53pk8T0zadI+2JIUlf7JjGD7DJcHljDNx1YTEzfvLBgHpLUWFFrAvQBFxTMQ53lYmL65Bpgv4J5SFKjXUfMYLsaOLxgHuoMR5JO1BF98tKCeUhS451G3CzAjeTfwEWdqxe4gbj++NJyqUhS840A7iFu0HVxIA3WWcT1w18WzEOSWuM9xA28C4Bp5VJRS00D5hHXD08rl4oktcdY4GHiBt9vl0tFLXUpcf3vLrwVJUkb9G7iBuA+4Ixyqahl/oTYvveOcqlIUvuMAu4jbhBeAOxaKhm1xi7AQuL63Z2kvi1J2oi3E3slNoOYnd3UTr3AVcT2uZOKZSNJLTYS+B2xA/I5pZJR432M2L52dbFMJKkDvIrYQXkVvo8teA1psaiofrYGOKxYNpLUIS4jtgiYBzyvWDZqmj2AJ4ntY/9WLBtJ6iDPB5YTO0DPBCaVSkiNMRG4jdi+tQLYvVRCktRpPkvsIN1Hmmnw/ezu0Qt8j/h+9clSCUlSJxpP7BLBa9vnSyWk6j5PfH+6g7SwlSRpMxxP3M5s67b3l0pI1Xyc+H60CneglKRsvk78wL0GeFehfFRe9CqTa9tnSyUkSd1gMjCb+MF7NfDHhXJSOX9E7Ot+a9vdpNtWkqSMTqTMrYBVwBsL5aR4bwBWUqZ4PKZQTpLUdc6jzDTu08DphXJSnHeQCroSfeb8QjlJUlcaA9xCmQF9DXB2mbQU4AOUmTHqA24GxpVJS5K61wHAUsoM7H2kh7p6imSmHHoos37E2vYEsFuRzCRJ/DHlBvg+4N+B0UUy0+YYA1xEuX6xBnf6k6TivkTZIuAqYEqRzDQcOwLXU7ZPfKpIZpKk9YwCrqHsgP8QcGSJ5DQkLwEepWxfuJq0dbUkqYIdgUcoO/CvwFUDm+TdlHnNb932MDCtRHKSpA07BFhE2RNAH/AfwBYF8tPAtiJtt1v6e19AehBVktQAr6Hc+97rtruBowvkp/WdQLodU/r7Xg4cWyA/SdIQvIPyJ4Q+0pPgF+BsQAnjSA/elVjWd6Dv+S3xKUqShuPvqVME9AGzSFeminEMZbaG3lD7YHyKkqTN8QXqnSTWAF8Dtg/PsnvsBHybcqv6DdTODc9SkrTZeoALqXey6CM9lPgxYEJwrp1sHPAJYAl1v8sLgd7gXCVJmYwgrd5X88TRR3pF8az+49Hg9AJ/CDxA/e/vi7gMtCS1zgjg69Q/ifQBtwKn4ZXkxowE3gzMpP731Uea9vfkL0kt1QP8M/VPJmvbvaRd6sZHJt0yo4Azgd9T//tZ2z4dmrEkqYge4DPUP6ms2x4D/gbYJjDvptse+AjwIPW/j3XbOYE5S5IqOJu6T5IP1JaQVrM7ge54TqAXeCXwPcov37upthpf9ZOkjvUGYBn1TzYDtYdJi9zsE5Z9PXuT3oq4j/qf80BtEXByWPaSpEY4EphL/ZPOxtpvgE8CL6adMwM9wOGkguZO6n+eG2sP4Nr+ktQ1ng/cRv2Tz2DaPOBi4E3AdhEfRia7kx7mu5DyOzQOt11Psz9TSVKAiaQV5mqfhIbaZgHfBT4EvAzYMu/HMihbka7w30v6DNtywl+3XQyMzf3BSG3hO65SevDr06T30NtoDene+r39f9dtD5O2r101xJjjgKmkPe+3JS3Huy/wAtL9/B1yHHglK0hvH6xdMlrqShYAUvJS0hXh9NoHEmQpsBB4ap2/o3nuUsWTSK/nTSx6dOXcCfwRcFPtA5EkNcckUhFQe2raFtO+QecWNpKkDM4kvRZW+4Rly9MWAm9EkqRBeB7wM+qfvGyb134C7IIkSUPQQ5oNmEf9E5ltaG1O/3fnc06SpGGbRlq6tvZJzbbptpq0he9WA36TkiQNw3GkbX1rn+RsA7ebSCsnSpKU3UjgfcB86p/wbKnNAd5DO5dMliS1zDbAuaT362ufALu1zSct6PPstQwkSQo3lbThTVN3GOzEtrj/M/c+vySpup2BC4Dl1D9BdmpbSpp12XaQ34kkScVMBc7BVwdztkf7P9Mpg/4WJEmqZAJpp7zfU/8E2tZ2DfAG2rtJkySpi/UAxwDfxOcEBtOWABcBhwznw5YkqYm2Jr1CeD1pC9/aJ9umtBXApcCbcLMeSVKH2wn4ADCD7iwGVvfn/gHScxOSCnOdbKm+3YBXAycCxwLj6x5OmPnAVaQNei4jPdwnqRILAKlZxgJHAycARwGHAqOqHtHwLSdd5f+kv91Emu2Q1AAWAFKzjQMOIxUDLwYOoJnb2z4N/A64ub/dBNxAevBRUgNZAEjtMwnYv7/tR7qFsBuwK2kGIdITwMPAg8D9wC2kk/3twMrg/9+SMrIAkDrLNFIxMJm0cM7k/rYNaencHmA066+fv5L0+t2S/n8vBFb1/32MdMJfe9JfWiIJSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkabh6ah+A1CVGAVOAyf1tCrAtsA2wZf9/ZwtgJDAamND/v9uKdv9On+z/uxxY9qz/3bL+f88D5gOP9/+dBywteIxSV2rzwCI1xXhgt/626zp/d+SZE/2WG/i/1cCW8UxhMAd4ELi/v83q//t4rYOTOoEFgDQ4I4EXAPsDBwC788zJfmq9w+pqS3imKLgfuAu4DbgVWFDxuKRWsACQnmtrYF/gUGCf/n8fAoyreVAaktnATOB3wG/6/30bsLLmQUlNYgGgbjceOAx4CXAEcDhpyl6dZxlwO/BL4FpgBvBI1SOSKrIAULeZBryQdMI/qv/fY6oekWqaTSoE1hYENwFrqh6RVIgFgDrdNsDxwCuBlwO71D0cNdxC4DrgKuDHpFsHUkeyAFCn6QUOBl7R344hvYInDcdjwJXApf1/F9Y9HCkfCwB1gm2BV5Ou8o8nvXon5baSdJvgxzg7oA5gAaC22gZ4LfAG0onfq3yV9gBwCfBdUmEgtYoFgNrEk76aahbwX8C/Ar+teyjS4FgAqOm2Bl5POukfS1qQR2qy24H/AL5DWpxIkjRIPaST/cWkd7f7bLaWtl8CbwcmIjWMMwBqkmnAmaQB8/mVj0XKaRHwn8A3gJ9UPhYJsABQfb2k9/PfCZyK9/XV+X5HKgS+CjxR+VjUxSwAVMu2wJ8B7yJd+UvdZgnpWYHzgZsrH4skhXs+8AXS4Ff7/qzN1pQ2AzgJL8okdaCjSE9Fr6L+YGuzNbXdBXwAGIsUzGpTkUYDpwB/Cbyo8rFIbfIY8GXgPHxOQFKLjAHeAzxE/Ssqm63NbRFwLrAdUmbOACin0cDbgI8CO1c+ljZ5ClhN2mhmDWnN+SX9/9ki0m2TNhoDjO//93ie2XZ5IjAO2KLGQbXUEuCLwGeA+ZWPRR3CAkA5jCK9v/83wK51D6UR1pD2mZ/V3+YA8/rb/AHa0zUOsgFGk5Z3nrzO37X/ngpMJxWSu5LeFHG8SgXhP5NmBRZUPha1nD8obY6RwJuAjwO7Vz6W0lYCd5De6b6HtDHMrP6/D/b/58pnDKkY2BnYpb+9ANgP2JPuWz/iSVIR8AVSUSANmQWAhuv1wD8Ae9Q+kGB9wP3AbaQ13tf+vYvuvXJvmlHAXsA+wAH9f/cHdiMtNNXJ5gGfBv4fsLzysUjqcIcAP6f+w1FRbT7wI9LtjOPwPnWbbQkcT5qh+hHpu63dv6LafcBpeT42SVrfNOBrpIfVag92OdvtwFdIDy/uhbNinayH9B2/lfSK3e3U73+521XAgZk+L0ldbjRpYZKF1B/ccrS5pAWJ3gnslPFzUjttR9pq+gLgEer3zxxtNWmvAV8dlDQsPcAZpAfbag9om9NWAD8D/go4lM6/J6zh6yX1kY+QrqRXUL//bk57Evhzuu8BSUmbYQ/SSbP2ADbctgT4PvBG0n1gaTgmkd5y+QGwlPr9erjtTuDYzJ+NpA4zkjTdv5j6g9ZQ21LgUtJ6BD64p9zGkTbr+QbtvB22pv/YJ+f+YCS13+HALdQfqIbSlgEXk/YbGJf/I5EGNBY4GfgWqQ/W/h0MpT2KbwtI6jce+BTt2qVvJvBhYErA5yENxSTSA6UzqP+7GEq7FB+Clbraq2nPQ35PkJ7UPjjig5Ay2JtUTM+h/u9lMG0B6ZafD8ZKXWRL0v3A2gPQptoa4Ergdfgks9pjFHAq8BNSH679O9pU+xlpaWVJHe7FwN3UH3Q21paTCpT9gj4DqZQ9Sev1N/3B2oXAm4M+A0mVjQTOodn3+h/tP0afVFanmUSabp9F/d/Zxtp3gK1jPgJJNewB/Ir6g8uG2vWk1dhGRn0AUkOMBE4HbqD+725D7V7giKgPQFI5Z5K2C609qAzUZpDerZa60VGkFQdr/w4Hak+THmj02RuphbYBfkj9gWSg9jPgZWGZS+1yHM3dYXMGsGtY5pKyO4g0jVd78BhoMDkuMG+pzY4ivZ9f+3f67DYfeGVg3pIyOZPmrVv+C+DIyKSlDnI06bmY2r/bddsq4K9xu2ypkUaS7tnVHijWbXeRHu5z0JCG7iSa98ruZcBWkUlLGpodgeuoPzisbfNIS/WOiUxa6gKjSEsNN2l1wbuA/SOTljQ4RwOzqT8o9JH2T/8C6Z1nSflMJK2R0ZTbe4uAMyITlrRxHyC9rlN7MOgDvo+bi0jRdgX+i/q/9z7SMsefwb0EpKJGAOdTfwDoAx7C7UWl0k4C7qf+77+P9Lrx+Nh0JQFMoBlXACtJ0/0TY9OVtAHjSLcFllN/PPgVsF1otlKX2x74NfV/7NcA+wbnKmlw9gT+h/rjwn2kLZElZbYv9TcSeRJ4K77WJzVND/AnwALqjhFPAMcE5yp1lZeTTr41f9hX4kN+UtNNI72rX3OsWAG8JTpRqRv8MekHVevHvAj4U7zql9qiB3g3sJh648Ya0sqBkobp3aQfUq0f8bWkrYQltc9upI23as4GnI8XD9KQ/RX1frRLgT/H93ultusF/hJYRr3x5Es4lkiD9mHq/Vh/DxwYn6Kkgg4mLeFba1y5mLRfiaQN6AE+T70f6fdwGV+pU20B/Dv1xpdLcH8QaUA9wHnU+WEuIy0rLKnznQksoc5YczlpASNJ/UYAF1HnB+mUv9R99gFmUmfM+TlpNkLqeiOA/6DOD/Fb+EOUutUW1Bt7rsaZAHW5HuBCyv/41pDWEJekDwCrKT8OXYnPBKiL1XjgbxFwSonkJLXGq6mzjPAP8e0AdaF/pPyP7V7cxEfSwPYjbehTelz6Jq4ToC7yUcr/yH4BTC2RnKTWmgz8lPLj09dwxUB1gfdS/sf1JWBUieQktd4o4MuUH6fOLZGcVMtbKbu2/xrg7BKJSeo4f035vUj+tkhmUmGvA1ZR7of0NGknQUkarrNIY0nJIuDtRTKTCjmUsltzLgFeUyQzSZ3uJMquHPg0cEKRzKRgOwIPU+7H8wRwVJHMJHWLw4G5lBvHnsIVStVyWwC3UO5H8yhwQJHMJHWbfYAHKTeePQLsVCQzKbORwBWU+7HcDexcJDNJ3WoX0noipca13wITi2QmZfRFyv1I7gKml0lLUpfbiXTBUWp8uxxXC1SL/AXlfhy/Jz1nIEmlTKdsEfDFMmlJm+cUym2scSewQ5m0JGk9O5JmH0sVAb4eqEbbg3Ibanjyl1TbdsBMyox5y4HDyqQlDc0E4HbK/BBmAtuXSUuSNmoa6YKkxNj3ALBtmbSkwftXyvwA7iP94CSpKXYE7qfMGHgVPhSoBnkfZTr+48ALCuUkSUPxfGAOZcbCTxfKSdqow4EVxHf4hcAhhXKSpOF4IWkVv+jxcA1weqGcpAFNBR4ivrOvAI4vlJMkbY5jgWXEj4uLgH0L5SStpxf4b+I7+Srg9YVykqQcTqHMLoIzgXGFcpL+v3MoM811VqF8JCmnPyV+jOwDziuVkATpPtdK4jv2J0slJEkBPkuZC6XXlkpI3W0Cafnd6E79fdJtBklqq17gP4kfLx/HtVFUwFeI78y/JRUaktR2E4GbiR83fwz0FMpJXehVpOmmyE78KO6BDIdEewAACmhJREFULamz7EKZNQLeUyohdZdtgdnEdt5lpHUFJKnTvBBYQvwYekCphNQ9ou9jubCFpE73JuJnUW8GRpdKSJ3v7cRPXX2qWDaSVM8/ET+efqxYNupo04lf2vIa3NxCUncYBVxP7Ji6HNi7VELqXD8ktqM+RtpJS5K6xXRgLrFj6/X4KrU2w+uI7aCrgROKZSNJzXEcaanzyDH23cWyUUfZgviNfj5RLBtJap5PEjvGLsTXqjUM5xPbMa8CRhTLRpKapxe4ktix9kfFslFHeBGxU1OzSVsJS1K32470LFRkEXBGsWzUaiOJX7bSjSsk6RmnEjvmzgEmFctGrfUhYjviV8qlIkmtcRGxY+/nyqWiNtoRWExcB7yX9HChJGl9WwKziBt/VwB7lkpG7fN14jrfauCYYplIUvscRezzV5eWS0VtchDpJB3V8VzqV5I27fPEjcN9pF1dpfVcRVyHuwUYUy4VSWqtscDtxI3HM0nLEUsAnExcZ1sFHFIuFUlqvRcTOyP7/nKpqMlGkirCqI52brlUJKljfIm4cfkJYEq5VNRU7yOukz2ET/1L0nBMAh4lbnw+r1wqaqKtiN2R6tRyqUhSxzmDuPF5BbBbuVTUNJ8mrnNdUjAPSepUlxM3Tn+1YB5qkCnAImI61RJg12KZSFLn2oW4BdpW4eJAXSny6v+DBfOQpE73YeLG628UzEMNMAV4ipjOdCe+YypJOY0G7iJuFmDvcqmotsirf3f6k6T8TiNu3P52wTxUUeTV/1UF85CkbnMNMWP3GuDAgnmokqir/9Wk/QQkSTEOI52sI8bwHxbMQxVMJu7q/18K5iFJ3erfiJsF2LdgHirsU8R0nMXADgXzkKRutTOwlJix/MKCeaigLYAFxHSac8qlIUld7++JGcuXA9sXzEOF/B9iOsw8XO9fkkqaRNrQJ2JM/7uCeaiAXuAeYjrLRwrmIUlKziFmTH8CmFguDUU7Fa/+JamTRM4CvK9gHgp2NTGd5K8K5iBJWt8niBnb7wNGFsxDQfbHq39J6kSRswBvKJiHglxETOf4aMkkJEkD+jgxY/x1JZNQflOBZeTvGPPx6l+SmiByFqCjlwfurX0Awd4FjA2Iex6wKCCuJGloFgJfDIp9VlBcBesFZpG/IlwObFcuDUnSJkTN9j4JjC+YhzI5gZgpoa+WTEKSNChfJ2bMf3PBHJTJt4jpDAeUTEKSNCj7E7NT4M9LJqHNtxUxm0VcUTIJSdKQXEXMhd/eJZPQ5nkvMZ3glSWTkCQNyUnEjP2fLZmENs9vyN8B7gR6SiYhSRqSHuAO8o//c4ExBfPQMB1ITAX4zpJJSJKG5T3EnANeVzIJDc8XyP/FL8KFfySpDSYBS8h/Hvh2ySQ0dCNJUzW5v/gLSyYhSdos3yD/eWAxMKFkEhqaqHf/jyiZhCRps7yMmHPB6QVz0BBdQP4v3If/JKldeoC7yX8++H7JJDR4I4DHyP+F/2XJJCRJWXyU/OeDZcCWJZPQ4BxL/i/7aWD7kklIkrLYnjSG5z4vvKlkEpE6aTfA0wJiXgrMCYgrSYo1B/jvgLhnBMTUZugFHiF/pXdKySQkSVm9nvznheWk5ebVEC8h/5e8EBhbMglJUlbjSa/veRtgAJ1yC+D1ATEvIVV6kqR2Wgr8KCDuqwJiapjuJ3+Fd3LRDCRJESJuAzxO51xAt9pe5P9yn8Lpf0nqBFG3AQ4rmUSETqhgTgiI6fS/JHWGpcDlAXFPDIhZVCcUAMcHxPxuQExJUh0RY3rrC4C2G03aqc/pf0nShkTcBlgNbFsyidzaPgNwJDAxc8zLcfpfkjrJUuB/MsfsJWYGupi2FwAR9/8jVo6SJNV1ZUBMXwes6EbyTumsAXYsmoEkqYRdyf8mgEvFVzKFdA8m55d5a9EMJEkl3Un+ImCPohlk1OZbAMeR//id/pekznVFQMyjAmIW0eYC4CUBMSM6hySpGSIu8o4MiKlN+DV5p3EWA2OKZiBJKmkc6Y2AnOeOO4pmIMYBK8j7JV5WNANJUg1XkPfcsYaWrgfQ1lsAh5IWAcrpqszxJEnN89PM8Xpo6W2AthYARwTEnBEQU5LULNcFxIx4Jk0b8APyTuEsJf+MgiSpecaQVnvNeQ65tmgGXe4R8n5515Q9fElSRdeR9xyynBbuIdPGWwC7Ajtkjun0vyR1j9xX7GOAfTLHDNfGAuDwgJjXB8SUJDVTxHMA+wfEDNXGAuCgzPH6sACQpG4SUQAcEBAzVBsLgP0yx/s9MC9zTElScz0G3Js5pgVAAftmjverzPEkSc2Xe+y3AAg2kfQQYE7uAChJ3ee2zPGmAttnjhmqbQXAvqRVl3KyAJCk7hMx9rdqFqBtBUDu+/+QvwqUJDWfBUDtAxii3Pf/55IeBpEkdZeHgfmZY7bqVcC2FQC5ZwCc/pek7nV75nitWgzIAkCS1K1y3wLeLXO8UG0qALYEpmWOmbv6kyS1R+6LwMmkc1UrtKkA2CUgpg8ASlL3irgIbM0sQLcXAPcExJQktUPu1QAh/1o1Ybq5AHgKeDJzTElSezwOLMkc0xmAALkLgPszx5Mktc8DmeNZAATYOXM8CwBJUu5zgQVAAGcAJEm5WQC0QO4ZgFmZ40mS2scCoOHGkH+XJWcAJEm5zwUTaMlaAG0pAKaT/1gtACRJEeeCyQExs2tLATA1IOYjATElSe0ScS6YEhAzu7YUANtkjrcKWJA5piSpfZ4A1mSOaQGQUe4CYD7QlzmmJKl9VpN/UTgLgIxyFwDzMseTJLVX7nOCBUBGFgCSpChzM8fzIcCMLAAkSVGcAWgwCwBJUpTcMwAWABnlLgCeyBxPktReuS8KW3ELYGTtAxik3AXAQcCHM8eUJLXTQZnjjcscL0RbCoDcyyqe2N8kScptbO0DGIy23AIYXfsAJEkapFacs9pSAIyqfQCSJA2SMwAZtaKakiSJtINt47WlAHAGQJLUFhYAGTkDIElqCwuAjJwBkCS1RSsKgJ7aBzBIq2lPsSJJ0gjybzOcVRtOqiNox3FKkrRW42eu23BibfyHKEnSOpYDK2ofxKa0oQBY3t8kSWqD3JsLhWhDAQAwu/YBSJI0SL+sfQCD0ZYCYEbtA5AkaZCurH0Ag9GWAuA/ax+AJEmDMA/4du2DGIy2FACXAL+rfRCSJG3C54DFtQ9iMNqyDgDAq4DLadcxS5K6x7XAy4BVlY9jUEbUPoAhuIe0INDLax+IJEnPcg9wErCg9oEMVpsKAIBfkCqrY3EmQJLUDDcCxwOP1j6QoWhbAQBwDekVi4OBqZWPRZLUvRYDHwfOAp6qfCxD1uar6BHAycCpwFHADsDYqkckSep0c4CbSA+nf4sWnvjXanMBMJBJtOfNBklSu6ymxSd8SZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSZIkSVK7/S9IZGpYRqICfQAAAABJRU5ErkJggg==', 1,'2023-06-25 21:15:00',true,0);

-- t_role
INSERT INTO t_role (role_name, role_code, created_by, created_at, is_active, ver) VALUES
	('Super Admin', 'sp1', 1,'2023-06-25 21:15:00',true,0),
	('HR', 'hr1', 1,'2023-06-25 21:15:00',true,0),
	('Reviewer', 'rv1', 1,'2023-06-25 21:15:00',true,0),
	('Candidate', 'cd1', 1,'2023-06-25 21:15:00',true,0);


--t_profile
INSERT INTO t_profile (full_name, phone_numb, profile_photo, created_by, created_at, is_active, ver) VALUES
	('Administrator', '40209816163', 1, 1,'2023-06-25 21:15:00',true,0);

-- t_user
INSERT INTO t_user (username, user_password, id_role, id_profile, created_by, created_at, is_active, ver) VALUES
	('admin', '$2a$12$kuWN3WqnEbBOG7LLyXDlO.Cj8m0k8ojRcxydPJk7LCv.PI7hVW6je', 1, 1, 1,'2023-06-25 21:15:00',true,0);

-- t_question_type
INSERT INTO t_question_type (type_question_name, type_code, created_by, created_at, is_active, ver) VALUES
	('Option', 'op1', 1,'2023-06-25 21:15:00',true,0),
	('Essay', 'es1', 1,'2023-06-25 21:15:00',true,0);

-- t_progress_status
INSERT INTO t_progress_status (status_name,status_code, created_by, created_at, is_active, ver) VALUES
	('on progress','onp1',1,'2023-06-25 21:15:00',true,0),
	('submitted','sbm1', 1,'2023-06-25 21:15:00',true,0);

-- t_result_status
INSERT INTO t_result_status (result_name, result_code,  created_by, created_at, is_active, ver) VALUES
	('needs review','nr1', 1,'2023-06-25 21:15:00',true,0),
	('rejected','rj1', 1,'2023-06-25 21:15:00',true,0),
	('considered','cs1', 1,'2023-06-25 21:15:00',true,0),
	('recommended','rc1', 1,'2023-06-25 21:15:00',true,0);
	
-- t_file_type
INSERT INTO t_file_type (type_name, created_by, created_at, is_active, ver) VALUES
	('CV', 1,'2023-06-25 21:15:00',true,0),
	('Ijazah', 1,'2023-06-25 21:15:00',true,0),
	('Transkrip Nilai', 1,'2023-06-25 21:15:00',true,0),
	('Kartu Keluarga', 1,'2023-06-25 21:15:00',true,0);