require 'test/unit'
require_relative 'lights'

class TestAoC6 < Test::Unit::TestCase
  def test_aoc_example_1
    sut = Lights.new(
      [
        'turn on 0,0 through 999,999',
        'toggle 0,0 through 999,0',
        'turn off 499,499 through 500,500'
      ]
    )

    lights_on = sut.run(:simple)

    assert_equal(998996, lights_on)
  end

  def test_aoc_example_2
    sut = Lights.new(
      [
        'turn on 0,0 through 0,0',
        'toggle 0,0 through 999,999'
      ]
    )

    lights_on = sut.run(:advanced)

    assert_equal(2000001, lights_on)
  end

  def test_aoc_puzzle_1
    file = 'aoc.txt'
    lines = []
    File.readlines(file).each do |line|
      lines << line
    end

    sut = Lights.new(lines)

    lights_on = sut.run(:simple)

    assert_equal(400410, lights_on)
  end

  def test_aoc_puzzle_2
    file = 'aoc.txt'
    lines = []
    File.readlines(file).each do |line|
      lines << line
    end

    sut = Lights.new(lines)

    lights_on = sut.run(:advanced)

    assert_equal(15343601, lights_on)
  end
end
